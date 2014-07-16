package com.vini.mysite.web;

import java.util.HashMap;
import java.util.Map;

import org.apache.wicket.Request;
import org.apache.wicket.Response;
import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebSession;

import com.vini.mysite.core.ec.User;

public class WicketSession extends WebSession {

	private static final long serialVersionUID = 1L;
	
	private User user;
	private Map<String, Object> params;
	
	public WicketSession(Request request, Response response) {
		super(request);
		params = new HashMap<String, Object>();
	}

	
	public static WicketSession get() {
		return (WicketSession)Session.get();
	}


	public void setUser(User user) {
		this.user = user;
	}


	public User getUser() {
		return user;
	}
	
	public boolean isAdmin(){
		if(null != user){
			return user.isAdmin();
		}else{
			return true;
		}
	}

	public void addParameter(String key, Object value) {
		this.params.put(key, value);
	}
	
	public Object getParameter(String key) {
		return this.params.get(key);
	}
	
}
