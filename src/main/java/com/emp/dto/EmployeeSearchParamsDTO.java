package com.emp.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class EmployeeSearchParamsDTO {

	String firstName;
	String lastName;
	String phoneNumber;
	LocalDate dob;
}
