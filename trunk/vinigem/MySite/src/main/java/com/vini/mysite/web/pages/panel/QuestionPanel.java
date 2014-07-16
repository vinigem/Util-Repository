package com.vini.mysite.web.pages.panel;

import org.apache.wicket.PageParameters;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

import com.vini.mysite.web.WicketSession;
import com.vini.mysite.web.pages.NewQuestionPage;

public class QuestionPanel extends Panel {

	private static final long serialVersionUID = 1L;
	
	public QuestionPanel(String id) {
		super(id);
		
		final Form<Void> form = new Form<Void>("form");
		
		final TextArea<String> title = new TextArea<String>("title",new Model<String>());
		final RequiredTextField<String> category = new RequiredTextField<String>("category",new Model<String>());
		final TextArea<String> description = new TextArea<String>("description", new Model<String>());
		
		title.setRequired(true);
		description.setRequired(true);

		AjaxSubmitLink post = new AjaxSubmitLink("post"){
			private static final long serialVersionUID = 1L;

			@Override
			public void onSubmit(AjaxRequestTarget target, Form<?> form) {
				PageParameters parameters = new PageParameters();
				parameters.add("title",title.getModelObject());
				WicketSession.get().addParameter("category", category.getModelObject());
				WicketSession.get().addParameter("description", description.getModelObject());
				setResponsePage(NewQuestionPage.class, parameters);
			}
		};
		form.setDefaultButton(post);
		form.add(title);
		form.add(category);
		form.add(description);
		form.add(post);
		add(form);
	}

}
