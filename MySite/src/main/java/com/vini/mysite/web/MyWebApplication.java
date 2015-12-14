package com.vini.mysite.web;

import org.apache.wicket.Request;
import org.apache.wicket.RequestCycle;
import org.apache.wicket.Response;
import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.protocol.http.WebRequest;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

import com.vini.mysite.web.pages.AddArticlePage;
import com.vini.mysite.web.pages.BasePage;
import com.vini.mysite.web.pages.CreateExcelPage;
import com.vini.mysite.web.pages.ForumPage;
import com.vini.mysite.web.pages.HomePage;
import com.vini.mysite.web.pages.LoginPage;
import com.vini.mysite.web.pages.NewQuestionPage;
import com.vini.mysite.web.pages.QuestionsPage;

public class MyWebApplication extends WebApplication {

	public Class<? extends BasePage> getHomePage() {
		return HomePage.class;
	}
	
	@Override
	protected void init() {
		// Spring Integration
		addComponentInstantiationListener(new SpringComponentInjector(this));
		
		// Bookmark pages
		bookmarkPages();
	}
	
	private void bookmarkPages() {
		mountBookmarkablePage("/page/interview-questions", QuestionsPage.class);
		mountBookmarkablePage("/admin/addArticle", AddArticlePage.class);
		mountBookmarkablePage("/forum", ForumPage.class);
		mountBookmarkablePage("/forum/${title}", NewQuestionPage.class);
		mountBookmarkablePage("/login", LoginPage.class);
		mountBookmarkablePage("/excel", CreateExcelPage.class);
	}

	@Override
	public Session newSession(Request request, Response response) {
		return new WicketSession(request, response);
	}
	
	@Override
	public RequestCycle newRequestCycle(Request request, Response response) {
		return new CustomRequestCycle(this, (WebRequest) request, response);
	}

}
