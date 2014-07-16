package com.vini.mysite.web.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.extensions.ajax.markup.html.tabs.AjaxTabbedPanel;
import org.apache.wicket.extensions.markup.html.tabs.AbstractTab;
import org.apache.wicket.extensions.markup.html.tabs.ITab;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

import com.vini.mysite.web.pages.panel.SignInPanel;
import com.vini.mysite.web.pages.panel.SignUpPanel;

public class LoginPage extends BasePage {
	
	public LoginPage() {
		List<ITab> tabs = new ArrayList<ITab>();
		tabs.add(new AbstractTab(new Model<String>("Sign In")) {
			private static final long serialVersionUID = 1L;

			@Override
			public Panel getPanel(String panelId) {
				return new SignInPanel(panelId);
			}
		});
		
		tabs.add(new AbstractTab(new Model<String>("Sign Up")) {
			private static final long serialVersionUID = 1L;

			@Override
			public Panel getPanel(String panelId) {
				return new SignUpPanel(panelId);
			}
		});
		
		add(new AjaxTabbedPanel("tabs", tabs));
	}

}
