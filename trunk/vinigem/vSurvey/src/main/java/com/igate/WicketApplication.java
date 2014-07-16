package com.igate;

import org.apache.wicket.Page;
import org.apache.wicket.Request;
import org.apache.wicket.Response;
import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.protocol.https.HttpsConfig;
import org.apache.wicket.protocol.https.HttpsRequestCycleProcessor;
import org.apache.wicket.request.IRequestCycleProcessor;
import org.apache.wicket.settings.Settings;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.apache.wicket.util.time.Duration;

import com.igate.web.pages.BasePage;
import com.igate.web.pages.PageExpired;
import com.igate.web.pages.SurveyPage;

/**
 * @author 719731
 *
 */
public class WicketApplication extends WebApplication
{    
	/**
	 * Constructor
	 */
	public WicketApplication()
	{
	}
	
	protected SpringComponentInjector getSpringInjector()
	{
		return new SpringComponentInjector(this);
	}

	@Override
	protected void init() {
		super.init();

		mountBookmarkablePage("home", BasePage.class);
		mountBookmarkablePage("survey", SurveyPage.class);
		
		addComponentInstantiationListener(getSpringInjector());
		
		getRequestCycleSettings().setRenderStrategy(Settings.ONE_PASS_RENDER);
		getRequestCycleSettings().setTimeout(Duration.ONE_MINUTE);
		getApplicationSettings().setPageExpiredErrorPage(PageExpired.class);
	}
	
	@Override
    protected IRequestCycleProcessor newRequestCycleProcessor() {
        HttpsConfig config = new HttpsConfig(8180, 8443);
        return new HttpsRequestCycleProcessor(config);
    }

	/* (non-Javadoc)
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends Page> getHomePage() {
		return BasePage.class;
	}
	
	@Override
	public Session newSession(Request request, Response response) {
		return new SurveySession(request);
	}

}
