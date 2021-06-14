/*
 * This entity class of Employee all attribute are defined in this class
 * */

package com.example.Employeeemanagement.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.format.annotation.DateTimeFormat;  

@Entity
@Table(name = "employees")
//@SQLDelete(sql = "UPDATE employees SET status=inactive WHERE id=?")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Employees {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name = "Firstname")
	private String firstname;
	
	@Column(name = "Lastname")
	private String lastname;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "DOB")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	
	@Column(name = "DOJ")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate doj;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "dept")
	private String dept;
	
	@Column(name = "salary")
	private BigDecimal salary;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "performance")
	private String performance;
	
	@Column(name = "achievement")
	private String achievement;
	
	@Column(name = "status")
	private String status;
	

	public Employees() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employees(long id, String firstname, String lastname, String email,LocalDate dob,
			LocalDate doj,String gender,String dept,BigDecimal salary,
			String address,String performance,String achievement,String status) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.dob = dob;
		this.doj = doj;
		this.gender = gender;
		this.dept = dept;
		this.salary = salary;
		this.address = address;
		this.performance = performance;
		this.achievement = achievement;
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public LocalDate getDoj() {
		return doj;
	}

	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}
	

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPerformance() {
		return performance;
	}

	public void setPerformance(String performance) {
		this.performance = performance;
	}

	public String getAchievement() {
		return achievement;
	}

	public void setAchievement(String achievement) {
		this.achievement = achievement;
	}
	
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Employees [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", dob=" + dob + ", doj=" + doj + ", gender=" + gender + ", dept=" + dept + ", salary=" + salary
				+ ", address=" + address + ", performance=" + performance + ", achievement=" + achievement + "]";
	}
	
	
      
}
