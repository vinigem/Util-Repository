package com.vini.mysite.core.ec;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name="createdDate", nullable=false, updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	
	@Column(name="lastUpdatedDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdatedDate;
	
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}
	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
	
	@PrePersist
	public void setCreationDates(){
		this.createdDate = new Date();
		this.lastUpdatedDate = new Date();
	}
	
	@PreUpdate
	public void setUpdationDates(){
		this.lastUpdatedDate = new Date();
	}
	
	@Override
	public String toString() {
		return "BaseEntity [createdDate=" + createdDate
				+ ", lastUpdatedDate=" + lastUpdatedDate + "]";
	}
	
	

}
