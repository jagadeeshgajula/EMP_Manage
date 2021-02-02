package com.emp.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity(name="employee_details")
@Data
public class EmployeeDetails {

	@Id
	@Column(name="employee_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer employeeId;
	
	@Column(name="first_name")
	String firstName;
	
	@Column(name="last_name")
	String lastName;
	
	@Column(name="phNo")
	String phoneNumber;
	
	@Column(name="dob")
	LocalDate dob;
	
	@OneToOne
	@JoinColumn(name="roll_id")
	EmployeeRoles employeeRole;
}
// one to one, one to many, many to one, many to many