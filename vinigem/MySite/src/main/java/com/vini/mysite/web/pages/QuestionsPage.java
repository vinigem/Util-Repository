package com.vini.mysite.web.pages;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.ajax.markup.html.navigation.paging.AjaxPagingNavigator;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PageableListView;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.vini.mysite.core.ec.Question;
import com.vini.mysite.core.si.IQuestionService;
import com.vini.mysite.web.pages.panel.AnswerPanel;

public class QuestionsPage extends BasePage {

	private List<Question> questions;
	private DropDownChoice<String> category;
	private TextField<String> texts;
	private PageableListView<Question> questionView;
	private ModalWindow modalWindow;
	private Form<Void> form;
	
	@SpringBean
	private IQuestionService questionService;

	public QuestionsPage() {
		//uploadQuestions();
		questions = questionService.findAll();
		
		form = new Form<Void>("form");
		add(form);

		add(getModalWindow());

		final WebMarkupContainer container = new WebMarkupContainer("container");
		container.setOutputMarkupId(true);
		container.setOutputMarkupPlaceholderTag(true);
		form.add(container);
		questionView = new PageableListView<Question>("questionView", new ArrayList<Question>(), 10) {
			private static final long serialVersionUID = 1L;
			@Override
			protected void populateItem(ListItem<Question> item) {
				Question question = item.getModelObject();
				item.add(new Label("question", new Model<String>(question.getQuestion())));
				item.add(new AjaxLink<String>("answer", new Model<String>(question.getAnswer())) {
					private static final long serialVersionUID = 1L;
					@Override
					public void onClick(AjaxRequestTarget target) {
						info(getModelObject());
						modalWindow.show(target);
					}
				});
			}
		};
		container.add(questionView);
		container.add(new AjaxPagingNavigator("navigator", questionView));
		container.setVersioned(false);
		container.setVisible(questionView.getList().size()>0);

		category = new DropDownChoice<String>("category", new Model<String>(), getCategories());
		category.setOutputMarkupId(true);
		category.add(new AjaxFormComponentUpdatingBehavior("onchange"){
			private static final long serialVersionUID = 1L;
			@Override
			protected void onUpdate(AjaxRequestTarget target) {
				questionView.setList(getQuestionsByCategory(category.getModelObject()));
				container.setVisible(questionView.getList().size()>0);
				target.addComponent(container);
			}
		});
		form.add(category);

		texts = new TextField<String>("texts", new Model<String>(""));
		texts.add(new AjaxFormComponentUpdatingBehavior("onkeyup"){
			private static final long serialVersionUID = 1L;

			@Override
			protected void onUpdate(AjaxRequestTarget target) {
				if(texts.getModelObject() != null){
					questionView.setList(getQuestionsByTexts(texts.getModelObject()));
					container.setVisible(questionView.getList().size()>0);
					target.addComponent(container);
				}
			}

		});
		form.add(texts);
	}


	private ModalWindow getModalWindow() {
		modalWindow = new ModalWindow("answerWindow");
		modalWindow.setOutputMarkupId(true);
		modalWindow.setContent(new AnswerPanel(modalWindow.getContentId()));
		modalWindow.setInitialHeight(200);
		modalWindow.setInitialWidth(600);
		modalWindow.setTitle("Answer");
		return modalWindow;
	}

	protected List<? extends Question> getQuestionsByCategory(String cat) {
		List<Question> questionList = new ArrayList<Question>();
		for(Question question: questions){
			if(question.getCategory().equals(cat)){
				questionList.add(question);
			}
		}
		return questionList;
	}

	protected List<? extends Question> getQuestionsByTexts(String texts) {
		List<Question> questionList = new ArrayList<Question>();
		for(Question question: questions){
			String quesDesc = question.getQuestion();
			if(quesDesc.toLowerCase().contains(texts.toLowerCase())){
				questionList.add(question);
			}
		}
		return questionList;
	}

	private List<? extends String> getCategories() {
		Set<String> categories = new HashSet<String>();
		for(Question question : questions){
			categories.add(question.getCategory());
		}
		return new ArrayList<String>(categories);
	}

	private void uploadQuestions() {
		questions = new ArrayList<Question>();
		try {
			//FileInputStream file = new FileInputStream(new File("src/main/resources/questions.xlsx"));
			InputStream file = this.getClass().getClassLoader().getResourceAsStream("questions.xlsx");
			//Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			//Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);
			//Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				if(row.getRowNum() == 0){
					continue;
				}
				Question question = new Question();
				question.setCategory(row.getCell(0).getStringCellValue());
				question.setQuestion(row.getCell(1).getStringCellValue());
				question.setAnswer(row.getCell(2).getStringCellValue());
				question = questionService.create(question);
				System.out.println(question);
				questions.add(question);
			}
			file.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
