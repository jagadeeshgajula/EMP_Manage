package com.emp.service;

import java.util.List;

import com.emp.model.EmployeeDetails;

public interface EmployeeDetailsService {

	
	public EmployeeDetails saveEmployeeDetails(EmployeeDetails employeeDetails);
	
	public EmployeeDetails updateEmployeeDetails(EmployeeDetails employeeDetails) throws Exception;
	
	public void deleteEmployeeDetails(Integer employeeDetailsId);
	
	public List<EmployeeDetails> getAllEmployeeDetails();
	
	public EmployeeDetails getByEmployeeDetailsId(Integer employeeDetailsId);
}
