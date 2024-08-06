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
}
