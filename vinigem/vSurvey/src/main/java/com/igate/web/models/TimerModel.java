package com.igate.web.models;

import org.apache.wicket.model.IModel;

public class TimerModel implements IModel<String> {

	private static final long serialVersionUID = 1L;
	
	private long timeLeft;
	
	public TimerModel(long seconds) {
		this.timeLeft = System.currentTimeMillis() + (seconds * 1000 );
	}

	public String getObject() {
		return String.valueOf( ( timeLeft - System.currentTimeMillis() ) / 1000 );
	}

	public void setObject(String object) {
		this.timeLeft = System.currentTimeMillis()+ (Long.valueOf(object) *1000);
		
	}
	
	public long getTimeLeft(){
		return this.timeLeft;
	}

	public void detach() {
		// TODO Auto-generated method stub
		
	}

}
