package com.vini.mysite.web.pages;

import org.apache.wicket.PageParameters;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.basic.MultiLineLabel;
import org.apache.wicket.model.Model;

import com.vini.mysite.web.WicketSession;
import com.vini.mysite.web.pages.panel.ReplyPanel;

public class NewQuestionPage extends BasePage {
	
	private ModalWindow replyWindow;
	
	public NewQuestionPage(PageParameters parameters) {
		final String title = parameters.getString("title");
		final String description = (String) WicketSession.get().getParameter("description");
		final String reply = (String) WicketSession.get().getParameter("reply");
		
		add(new Label("title", new Model<String>(title)));
		add(new MultiLineLabel("description", new Model<String>(description)));
		add(new MultiLineLabel("replyComment", new Model<String>(reply == null ? "" : reply)));
		
		add(new AjaxLink<Void>("reply") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				replyWindow.show(target);
				
			}
			
		});
		
		add(getReplyWindow(title));
	}

	private ModalWindow getReplyWindow(String title) {
		replyWindow = new ModalWindow("replyWindow");
		replyWindow.setOutputMarkupId(true);
		replyWindow.setContent(new ReplyPanel(replyWindow.getContentId(), title));
		replyWindow.setTitle(new Model<String>("Reply"));
		replyWindow.setInitialHeight(300);
		replyWindow.setInitialWidth(620);
		return replyWindow;
	}

}
