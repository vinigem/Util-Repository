package com.vini.mysite.core.ec;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="userId")
	private Long userId;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="role", nullable=false, length=1)
	private String role;
	
	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getRole() {
		return role;
	}
	
	public boolean isAdmin(){
		return "A".equals(this.role);
	}
	
	public boolean isMember(){
		return "M".equals(this.role);
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", role=" + role + ", userId=" + userId
				+", "+ super.toString()+ "]";
	}
	
	

}
