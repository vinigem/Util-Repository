package com.igate.core.ec;

import java.io.Serializable;
import java.util.List;

public class Question implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String text;
	private List<String> options;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public List<String> getOptions() {
		return options;
	}
	public void setOptions(List<String> options) {
		this.options = options;
	}
	

}
