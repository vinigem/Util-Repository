package com.vini.mysite.web.pages.panel;

import org.apache.wicket.PageParameters;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

import com.vini.mysite.web.WicketSession;
import com.vini.mysite.web.pages.NewQuestionPage;

public class ReplyPanel extends Panel {

	private static final long serialVersionUID = 1L;

	public ReplyPanel(String id, final String title) {
		super(id);
		Form<Void> form = new Form<Void>("form");
		add(form);
		
		final TextArea<String> reply = new TextArea<String>("reply", new Model<String>());
		form.add(reply);
		
		form.add(new AjaxSubmitLink("save"){
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				PageParameters parameters = new PageParameters();
				parameters.add("title", title);
				WicketSession.get().addParameter("reply", reply.getModelObject());
				setResponsePage(NewQuestionPage.class, parameters);			
			}
			
		});
	}

}
