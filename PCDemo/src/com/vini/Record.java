package com.vini;

import java.io.Serializable;

public class Record implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String value;
	
	public Record() {
		// TODO Auto-generated constructor stub
	}
	
	public Record(int id, String value) {
		this.id = id;
		this.value = value;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "Record [id=" + id + ", value=" + value + "]";
	}

}
