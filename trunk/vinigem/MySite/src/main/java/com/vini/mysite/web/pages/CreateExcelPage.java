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

	public CreateExcelPage() {
		excelContainer = new WebMarkupContainer("excelContainer");
		excelContainer.setOutputMarkupId(true);

		excelListView = new PageableListView<ArrayList<String>>("rows", new ArrayList<ArrayList<String>>(),5) {
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
						newRow.add("Row"+(excelList.size()+1) +"Column"+index);
					}
					excelList.add(excelList.size(), (ArrayList<String>) newRow);
				}else{
					excelList.add(new ArrayList<String>(Arrays.asList("Row1 Column1")));
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
						if(rowList.size() > 0 ){
							rowList.add(rowList.size(), "Row"+index+" Column"+(rowList.size()+1));
						}else{
							rowList.add("Row"+index+" Column1");
						}
					}
				}else{
					excelListView.getModelObject().add(new ArrayList<String>(Arrays.asList("Row1 Column1")));
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

}
