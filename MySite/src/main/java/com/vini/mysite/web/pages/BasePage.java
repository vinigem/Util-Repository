package com.vini.mysite.web.pages;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.IAjaxIndicatorAware;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.html.CSSPackageResource;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;

import com.vini.mysite.core.ec.User;
import com.vini.mysite.web.WicketSession;

public class BasePage extends WebPage implements IAjaxIndicatorAware{

	protected ModalWindow messageWindow;
	
	public BasePage() {
		initResources();
		add(getMessageWindow());
		
		//Home Link
		add(homePageLink("homeLink"));
		
		//Admin Link Container and Admin Links
		WebMarkupContainer adminLinkContainer = new WebMarkupContainer("adminLinkContainer");
		adminLinkContainer.setOutputMarkupId(true);
		add(adminLinkContainer);
		adminLinkContainer.setVisible(WicketSession.get().isAdmin());
		
		adminLinkContainer.add(new BookmarkablePageLink<Void>("adminLink", HomePage.class));
		adminLinkContainer.add(new BookmarkablePageLink<Void>("addArticleLink", AddArticlePage.class));
		adminLinkContainer.add(new BookmarkablePageLink<Void>("uploadQuestionsLink", HomePage.class));
		adminLinkContainer.add(new BookmarkablePageLink<Void>("answerQuestionsLink", HomePage.class));
		
		//Articles Link
		add(new BookmarkablePageLink<Void>("articleLink", HomePage.class));
		
		//Interview Questions Link
		add(new BookmarkablePageLink<Void>("interviewQuestionsLink", QuestionsPage.class));
		
		//Forum Link
		add(new BookmarkablePageLink<Void>("forumLink", ForumPage.class));
		
		//Login Container and Sign In and Sign Out Link
		WebMarkupContainer loginContainer = new WebMarkupContainer("loginContainer");
		loginContainer.setOutputMarkupId(true);
		Link<Void> signInLink = new BookmarkablePageLink<Void>("signInLink", LoginPage.class);
		AjaxLink<Void> signOutLink  = new AjaxLink<Void>("signOutLink") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				WicketSession.get().setUser(new User());
				setResponsePage(HomePage.class);
			}
		};
		loginContainer.add(signInLink);
		loginContainer.add(signOutLink);
		
		if(WicketSession.get().getUser() != null){
			signInLink.setVisible(false);
			signOutLink.setVisible(true);
		}else{
			signInLink.setVisible(true);
			signOutLink.setVisible(false);
		}
		add(loginContainer);
				
		//Contact Us Link
		add(new BookmarkablePageLink<Void>("contactUsLink", HomePage.class));
		
		add(new Label("footerMessage", new Model<String>("v0.0.1")));
	}

		private void initResources() {
		//Add all required css files
		add(CSSPackageResource.getHeaderContribution("styles/menu.css"));
		add(CSSPackageResource.getHeaderContribution("styles/layout.css"));
		add(CSSPackageResource.getHeaderContribution("styles/style.css"));
		
		//Add all scripts
		//add(JavascriptPackageResource.getHeaderContribution("scripts/tinymce/tinymce.min.js"));
		//add(JavascriptPackageResource.getHeaderContribution("scripts/common.js"));
		
	}

	private ModalWindow getMessageWindow() {
		messageWindow = new ModalWindow("messageWindow");
		messageWindow.setOutputMarkupId(true);
		messageWindow.setContent(new FeedbackPanel(messageWindow.getContentId()));
		messageWindow.setTitle(new Model<String>("Message"));
		messageWindow.setInitialHeight(100);
		messageWindow.setInitialWidth(400);
		return messageWindow;
	}

	@Override
	public String getAjaxIndicatorMarkupId() {
		return "overlay_div";
	}

	
	

}
