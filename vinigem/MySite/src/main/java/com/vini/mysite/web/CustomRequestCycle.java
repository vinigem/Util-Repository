package com.vini.mysite.web;

import org.apache.wicket.Page;
import org.apache.wicket.Response;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.protocol.http.WebRequest;
import org.apache.wicket.protocol.http.WebRequestCycle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomRequestCycle extends WebRequestCycle {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomRequestCycle.class);

	public CustomRequestCycle(WebApplication application, WebRequest request,
			Response response) {
		super(application, request, response);
	}
	
	@Override
	protected void onBeginRequest() {
		LOGGER.debug("onBeginRequest");
		super.onBeginRequest();
	}
	
	@Override
	protected void onEndRequest() {
		LOGGER.debug("onEndRequest");
		super.onEndRequest();
	}
	
	@Override
	public Page onRuntimeException(Page page, RuntimeException e) {
		LOGGER.error("Page {} Exception {}", page, e.getMessage());
		return super.onRuntimeException(page, e);
	}
	
	@Override
	protected void logRuntimeException(RuntimeException e) {
		LOGGER.error(e.getMessage());
		super.logRuntimeException(e);
	}

}
