package com.vini.mysite.web.pages.panel;

import java.io.FileWriter;
import java.io.IOException;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.include.Include;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.protocol.http.WebApplication;

public class PreviewPanel extends Panel {
	private static final long serialVersionUID = 1L;

	public PreviewPanel(String id, String content) {
		super(id);
		String path = WebApplication.get().getServletContext().getRealPath("/articles/article.html");
		try {
			FileWriter writer = new FileWriter(path);
			writer.write(getTopContent());
			writer.append(content);
			writer.append(getBottomContent());
			writer.flush();
			add(new Include("content","articles/article.html"));
		} catch (IOException e) {
			add(new Label("content",""));
		}
	}

	private CharSequence getBottomContent() {
		return "</body>" +
		"</html>";
	}

	private String getTopContent() {
		return "<html>" +
		"<head>" +
		"<title>Preview</title>" +
		"</head>" +
		"<body>";
	}

}
