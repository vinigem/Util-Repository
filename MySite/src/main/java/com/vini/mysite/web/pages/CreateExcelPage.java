package com.vini.mysite.web.pages;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.OnChangeAjaxBehavior;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.ajax.markup.html.navigation.paging.AjaxPagingNavigator;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.DownloadLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.list.PageableListView;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.Model;

import com.vini.mysite.util.ExcelUtil;

public class CreateExcelPage extends BasePage {

	private WebMarkupContainer excelContainer;
	private PageableListView<ArrayList<String>> excelListView;
	private AjaxLink<Void> addRowLink;
	private AjaxLink<Void> addColLink;
	private DownloadLink exportLink;
	private List<ArrayList<String>> rows;
	private int COL_COUNTER = 1;
	private int ROW_COUNTER = 1;

	public CreateExcelPage() {
		initExcel();
		excelContainer = new WebMarkupContainer("excelContainer");
		excelContainer.setOutputMarkupId(true);

		excelListView = new PageableListView<ArrayList<String>>("rows", rows,15) {
			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<ArrayList<String>> row) {
				row.add(new ListView<String>("cols", row.getModelObject()) {
					private static final long serialVersionUID = 1L;

					@Override
					protected void populateItem(final ListItem<String> item) {
						final TextField<String> column = new TextField<String>("column",  new Model<String>(item.getModelObject()));
						column.add(new OnChangeAjaxBehavior() {
							private static final long serialVersionUID = 1L;

							@Override
							protected void onUpdate(AjaxRequestTarget target) {
								item.setModelObject(column.getModelObject());
								target.addComponent(excelContainer);
							}
						});
						item.add(column);
					}
				}.setOutputMarkupId(true));

			}


		};
		excelListView.setOutputMarkupId(true);
		PagingNavigator navigator = new AjaxPagingNavigator("navigator", excelListView);
		excelContainer.add(navigator);
		excelContainer.add(excelListView);

		addRowLink = new AjaxLink<Void>("addRow") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				List<ArrayList<String>> excelList = excelListView.getModelObject();
				if(excelList.size() > 0){
					List<String> newRow = new ArrayList<String>();
					for(int index = 1; index <= excelList.get(0).size(); index++){
						if(index == 1){
							newRow.add(String.valueOf(ROW_COUNTER));
							ROW_COUNTER++;
						}else{
						newRow.add("R"+(excelList.size()+1) +"C"+index);
						}
					}
					excelList.add(excelList.size(), (ArrayList<String>) newRow);
				}else{
					excelList.add(new ArrayList<String>(Arrays.asList(String.valueOf(ROW_COUNTER))));
					ROW_COUNTER++;
				}
				target.addComponent(excelContainer);
			}
		};

		addColLink = new AjaxLink<Void>("addCol") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				if(excelListView.getModelObject().size() > 0){
					for(int index =1 ; index <= excelListView.getModelObject().size(); index++){
						List<String> rowList = excelListView.getModelObject().get(index-1); 	
						if(index == 1 ){
							if(COL_COUNTER < 26){
								char col = (char) (COL_COUNTER+65);
								rowList.add(rowList.size(), String.valueOf(col));
								COL_COUNTER++;
							}else{
								char colPrefix = (char) ((COL_COUNTER / 26)+65-1);
								char colSuffix = (char) ((COL_COUNTER % 26)+65);
								rowList.add(rowList.size(), String.valueOf(colPrefix+""+colSuffix));
								COL_COUNTER++;
							}
						}else{
							rowList.add(rowList.size(), "R"+index+" C"+(rowList.size()+1));
						}
					}
				}
				target.addComponent(excelContainer);
			}
		};
		
		exportLink = new DownloadLink("export", new AbstractReadOnlyModel<File>() {
			private static final long serialVersionUID = 1L;

			@Override
			public File getObject() {
				return ExcelUtil.createExcel(excelListView.getModelObject());
			}
		},"MyFile.xlsx");

		add(excelContainer);
		add(addRowLink);
		add(addColLink);
		add(exportLink);
	}

	private void initExcel() {
		rows = new ArrayList<ArrayList<String>>();
		ArrayList<String> headerRow = new ArrayList<String>();
		headerRow.add("");//Left Corner Empty cell
		headerRow.add("A");
		rows.add(headerRow);
	}

}
