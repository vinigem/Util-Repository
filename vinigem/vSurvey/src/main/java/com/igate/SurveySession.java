package com.igate;

import java.util.Map;

import org.apache.wicket.Request;
import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebSession;

public class SurveySession extends WebSession {

	private static final long serialVersionUID = 1L;
	
	private int questionIndex;
	private Map<Integer,String>answers;
	private String timeLeft  ;

	public SurveySession(Request request) {
		super(request);
		questionIndex = 0;
		timeLeft = null;
		
	}
	
	public static SurveySession get(){
		return (SurveySession) Session.get();
	}

	public void setQuestionIndex(int questionIndex) {
		this.questionIndex = questionIndex;
	}

	public int getQuestionIndex() {
		return questionIndex;
	}

	public void setAnswers(Map<Integer,String> answers) {
		this.answers = answers;
	}

	public Map<Integer,String> getAnswers() {
		return answers;
	}

	public void setTimeLeft(int timeLeft) {
		this.timeLeft = ""+(System.currentTimeMillis() + (timeLeft * 1000 ));
	}

	public long getTimeLeft() {
		if(timeLeft!=null){
			return Long.valueOf( ( Long.valueOf(timeLeft) - System.currentTimeMillis() ) / 1000 );
		}else{
			return 0;
		}
		
	}

	

}
