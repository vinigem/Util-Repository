package com.igate.web.pages;

import org.apache.wicket.Application;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class PageExpired extends WebPage {
	
	public PageExpired() {
		add(new Label("message", "Page Expired..!!"));
		add(new AjaxLink<String>("homeLink") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				setResponsePage(Application.get().getHomePage());
				
			}
		});
	}


}
