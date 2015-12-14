package com.igate.web.pages;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;
import org.apache.wicket.protocol.http.WebRequest;

public class BasePage extends WebPage {
	
	public BasePage() {
		((WebRequest)getRequest()).getHttpServletRequest().getSession().setMaxInactiveInterval(900);
		getSession().bind(); 
		//add header
		add(new Label("header", new Model<String>(getString("header"))));
		
		add(new AjaxLink<String>("start") {

			/**
			 * Link to start
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				setResponsePage(SurveyPage.class);
				
			}
		}.setVisible(getRequest().getURL().contains("home")) );
		
		//add footer
		add(new Label("footer", new Model<String>(getString("footer"))));
	}

}
