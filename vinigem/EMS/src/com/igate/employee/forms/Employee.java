package com.igate.employee.forms;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="employee")
public class Employee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Pattern(regexp="^[0-9]{6}",message="Employee Id should be 6 digits only!!")
	private String eid;
	
	
	@Pattern(regexp="^[a-zA-Z]+$",message="Name should contain characters only!!")
	private String fName;
	
	@Pattern(regexp="^[a-zA-Z]+$",message="Name should contain characters only!!")
	private String lName;
	
	
	@Pattern(regexp="^[0-9]{3}$",message="Department Number must be 3 digits!!")
	private String deptNo;
	
	
	@Pattern(regexp="^[0-9]{6,10}$",message="Salary should be between 6 to 10 digits!!")
	private String salary;
	
	@Id
	@Column(name="eid")
	public String getEid() {
		return eid;
	}
	public void setEid(final String eid) {
		this.eid = eid;
	}
	@Column(name="fName")
	public String getfName() {
		return fName;
	}
	public void setfName(final String fName) {
		this.fName = fName;
	}
	@Column(name="lName")
	public String getlName() {
		return lName;
	}
	public void setlName(final String lName) {
		this.lName = lName;
	}
	@Column(name="deptNo")
	public String getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(final String deptNo) {
		this.deptNo = deptNo;
	}
	@Column(name="salary")
	public String getSalary() {
		return salary;
	}
	public void setSalary(final String salary) {
		this.salary = salary;
	}

}
