package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class EmployeeEntity {	
	
	private int employeeId;
	private String employeeName;
	private String emailId;
	private String password;
	private int salary;
	
	public EmployeeEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeEntity( String employeeName, String emailId, String password, int salary) {
		super();
	
		this.employeeName = employeeName;
		this.emailId = emailId;
		this.password = password;
		this.salary = salary;
	}
	
	@Id
	@GeneratedValue
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
   @Column(unique=true) //do not allow duplicate email
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "EmployeeEntity [employeeId=" + employeeId + ", employeeName=" + employeeName + ", emailId=" + emailId
				+ ", password=" + password + ", salary=" + salary + "]";
	}
	
	
	
	
	
	
	
	
	

}
