package com.vini.mysite.web.pages;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.model.Model;

import com.vini.mysite.web.pages.panel.QuestionPanel;

public class ForumPage extends BasePage {
	
	private ModalWindow questionWindow;

	public ForumPage() {
		add(getQuestionWindow());
		
		//Ask Question Link
		add(new AjaxLink<Void>("askQuestionLink") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				// To avoid confirmation while redirecting from popup
				target.appendJavascript("Wicket.Window.unloadConfirmation = false;");
				questionWindow.show(target);
				
			}
		});
	}
	
	private ModalWindow getQuestionWindow() {
		questionWindow = new ModalWindow("questionWindow");
		questionWindow.setOutputMarkupId(true);
		questionWindow.setContent(new QuestionPanel(questionWindow.getContentId()));
		questionWindow.setTitle(new Model<String>("Message"));
		questionWindow.setInitialHeight(300);
		questionWindow.setInitialWidth(620);
		return questionWindow;
	}

}
