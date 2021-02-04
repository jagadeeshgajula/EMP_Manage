package com.emp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity(name="employee_addresses")
@Data
public class EmployeeAddress {

	@Id
	@Column(name="address_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer addressId;
	
	@Column(name="street1")
	String streetOne;
	
	@Column(name="street2")
	String streetTwo;
	
	@Column(name="city")
	String city;
	
	@Column(name="state")
	String state;
	
	@Column(name="country")
	String country;
	
	@Column(name="zipcode")
	String zipCode;
	
	@OneToOne
	@JoinColumn(name="employee_Id")
	EmployeeDetails employeeId;
}
