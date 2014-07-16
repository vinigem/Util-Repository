package com.igate.employee.forms;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="login")
public class Login implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	
	@Pattern(regexp="^[a-zA-Z0-9]+$", message = "Login ID must be Alpha-Numeric with no Spaces!!")
	private String loginID;
	
	@Size(min=4,max=12,message="Password must be between 4-12 characters!!")
	private String password;
	
	@Id
	@Column(name="loginId")
	public String getLoginID() {
		return loginID;
	}
	public void setLoginID(final String loginID) {
		this.loginID = loginID;
	}
	@Column(name="password")
	public String getPassword() {
		return password;
	}
	public void setPassword(final String password) {
		this.password = password;
	}

}
