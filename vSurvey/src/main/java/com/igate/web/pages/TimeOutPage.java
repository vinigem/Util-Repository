package com.igate.web.pages;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;

public class TimeOutPage extends BasePage {
	
	public TimeOutPage() {
		add(new Label("message", new Model<String>("Times Up!! Your survey has been submitted.")));
	}

}
