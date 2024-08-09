package edu.alpha.ems.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Employee {
	@Id
	// EmployeeId as to be Generated Automatically
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int emaployeeId;
	private String employeeName;
	// To make the Email column have unique values..
	@Column(unique = true)
	private String employeeEmail;
	private String password;
	private String designation;
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	@ManyToOne
	@JoinColumn
	private Department department;

	public int getEmaployeeId() {
		return emaployeeId;
	}

	public void setEmaployeeId(int emaployeeId) {
		this.emaployeeId = emaployeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [emaployeeId=" + emaployeeId + ", employeeName=" + employeeName + ", employeeEmail="
				+ employeeEmail + ", password=" + password + ", designation=" + designation + ", address=" + address
				+ "]";
	}

}
