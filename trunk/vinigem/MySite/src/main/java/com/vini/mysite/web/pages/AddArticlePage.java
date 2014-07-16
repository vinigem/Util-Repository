package com.vini.mysite.web.pages;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.panel.EmptyPanel;
import org.apache.wicket.model.Model;

import com.vini.mysite.web.pages.panel.PreviewPanel;

import wicket.contrib.tinymce.TinyMceBehavior;
import wicket.contrib.tinymce.ajax.TinyMceAjaxSubmitModifier;
import wicket.contrib.tinymce.settings.TinyMCESettings;
import wicket.contrib.tinymce.settings.TinyMCESettings.Align;
import wicket.contrib.tinymce.settings.TinyMCESettings.Location;
import wicket.contrib.tinymce.settings.TinyMCESettings.Theme;

public class AddArticlePage extends BasePage {
	
	private ModalWindow previewWindow;


	public AddArticlePage() {
		add(getPreviewWindow());
		Form<Void> form = new Form<Void>("form");
		add(form);
		
		final TextArea<String> textArea = new TextArea<String>("textarea", new Model<String>());
		
		TinyMCESettings settings = new TinyMCESettings(Theme.advanced);
		settings.setToolbarLocation(Location.top);
		settings.setToolbarAlign(Align.left);
		textArea.add(new TinyMceBehavior(settings));
		form.add(textArea);
		
		AjaxButton preview = new AjaxButton("preview") {
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				previewWindow.setContent(new PreviewPanel(messageWindow.getContentId(),textArea.getModelObject()));
				previewWindow.show(target);
			}
		};
		preview.add(new TinyMceAjaxSubmitModifier());
		form.add(preview);
		
		
		AjaxButton save = new AjaxButton("save") {
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				System.out.println(textArea.getModelObject());
				
			}
		};
		save.add(new TinyMceAjaxSubmitModifier());
		form.add(save);
	}

	
	private ModalWindow getPreviewWindow() {
		previewWindow = new ModalWindow("previewWindow");
		previewWindow.setOutputMarkupId(true);
		previewWindow.setContent(new EmptyPanel(previewWindow.getContentId()));
		previewWindow.setTitle(new Model<String>("Preview"));
		previewWindow.setInitialHeight(400);
		previewWindow.setInitialWidth(1000);
		return previewWindow;
	}
}
