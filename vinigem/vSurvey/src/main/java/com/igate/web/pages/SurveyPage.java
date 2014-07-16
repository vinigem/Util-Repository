package com.igate.web.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.AjaxSelfUpdatingTimerBehavior;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RadioChoice;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.protocol.https.RequireHttps;
import org.apache.wicket.util.time.Duration;

import com.igate.SurveySession;
import com.igate.core.ec.Question;
import com.igate.web.models.TimerModel;

@RequireHttps
public class SurveyPage extends BasePage {
	
	private List<Question> questions;
	private String selected;
	private Map<Integer, String> answers;
	private List<Integer>answerList;
	
	public SurveyPage() {
		//For Timer
		System.out.println("1.Time Left "+SurveySession.get().getTimeLeft());
		if(SurveySession.get().getTimeLeft()==0){
			SurveySession.get().setTimeLeft(30);
		}
		System.out.println("2.Time Left "+SurveySession.get().getTimeLeft());
		Label timer = new Label("timer", new TimerModel(SurveySession.get().getTimeLeft()));
		timer.add(new AjaxSelfUpdatingTimerBehavior(Duration.ONE_SECOND){

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			@Override
			protected void onPostProcessTarget(AjaxRequestTarget target) {
				if(SurveySession.get().getTimeLeft()<=0){
					setResponsePage(new TimeOutPage());
				}
			}
			
		});
		add(timer);	
		
		getQuestions();
		final int count = SurveySession.get().getQuestionIndex();
		System.out.println("Count-->"+count);
		answers = SurveySession.get().getAnswers();
		if(answers==null){
			answers  = new HashMap<Integer, String>();
		}
		if(answers.containsKey(count+1)){
			this.selected = answers.get(count+1);
		}
		
		answerList = getAnswerList();
		
		final ListView<Integer> questListView = new ListView<Integer>("questListView", answerList) {
			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(final ListItem<Integer> item) {
				item.add(new AjaxSubmitLink("button") {
					private static final long serialVersionUID = 1L;

					@Override
					public void onSubmit(AjaxRequestTarget target, Form<?> form) {
					SurveySession.get().setQuestionIndex(item.getModelObject());	
						setResponsePage(new SurveyPage());
					}
				}.add(new Label("index", ""+(item.getIndex()+1))));
				
			}
		};
		
		Form<Void> form = new Form<Void>("form");
		
		
		add(new Label("title", new Model<String>(getString("surveyTitle"))));
		
		WebMarkupContainer container = new WebMarkupContainer("container");
		WebMarkupContainer questionContainer = new WebMarkupContainer("questionContainer");
		WebMarkupContainer optionContainer = new WebMarkupContainer("optionContainer");
		
		WebMarkupContainer buttonContainer = new WebMarkupContainer("buttonContainer");
		
		WebMarkupContainer sideContainer = new WebMarkupContainer("sideContainer");
		/*sideContainer.setOutputMarkupId(true);
		sideContainer.setEnabled(true);*/
		sideContainer.add(questListView);
		Label quesLabel = new Label("question", new Model<String>(questions.get(count).getText()));
		questionContainer.add(quesLabel);
		
		//variable to hold radio button values
		
		//choices in radio button
		final RadioChoice<String> options = new RadioChoice<String>("options",new PropertyModel<String>(this, "selected"), questions.get(count).getOptions()){
			private static final long serialVersionUID = 1L;

			@Override
			protected void onModelChanged() {
				System.out.println("New Selected value2-->"+this.getModelObject());
				answers.put(count+1, this.getModelObject());
				SurveySession.get().setAnswers(answers);
			}
		};
		optionContainer.add(options);
				
		buttonContainer.add(new AjaxSubmitLink("back"){
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				SurveySession.get().setQuestionIndex(count-1);
				setResponsePage(new SurveyPage());
				
			}
			
		}.setVisible(count > 0));
		
		buttonContainer.add(new AjaxSubmitLink("next"){
			private static final long serialVersionUID = 1L;

			@Override
			public void onSubmit(AjaxRequestTarget target, Form<?> form) {
				SurveySession.get().setQuestionIndex(count+1);
				setResponsePage(new SurveyPage());
				
			}
			
		}.setVisible(count < (questions.size()-1)));
		
		
		buttonContainer.add(new AjaxSubmitLink("submit"){
			private static final long serialVersionUID = 1L;

			@Override
			public void onSubmit(AjaxRequestTarget target, Form<?> form) {
				setResponsePage(SurveyPage.this);
				
			}
			
		});
		container.add(questionContainer);
		container.add(optionContainer);
		form.add(sideContainer);
		form.add(container);
		form.add(buttonContainer);
		add(form);
		/*add(new AjaxLink<String>("calc") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				try {
					Runtime.getRuntime().exec("calc");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});*/
		
		
		
	}

	private List<Integer> getAnswerList() {
		List<Integer> keys = new ArrayList<Integer>();
		for (int i=0; i<questions.size(); i++) {
			keys.add(i);
		}
		return keys;
	}

	private void getQuestions() {
		questions = new ArrayList<Question>();
		
		for(int index=0; index<5; index++){
			Question question = new Question();
			question.setText("Question "+(index+1));
			List<String>options = new ArrayList<String>();
			options.add("Option 1");
			options.add("Option 2");
			options.add("Option 3");
			options.add("Option 4");
			question.setOptions(options);
			questions.add(question);
		}
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}

	public String getSelected() {
		return selected;
	}

}
