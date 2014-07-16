package com.vini.mysite.core.enums;

public enum Role {
	
	ADMIN("A"), MEMBER("M");
	
	private String code;
	
	private Role(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	

}
