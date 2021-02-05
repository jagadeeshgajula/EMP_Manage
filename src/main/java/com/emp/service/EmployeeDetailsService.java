package com.emp.service;

import java.util.List;

import com.emp.model.EmployeeDetails;
import com.emp.model.EmployeeRoles;

public interface EmployeeDetailsService {

	
	public EmployeeDetails saveEmployeeDetails(EmployeeDetails employeeDetails);
	
	public EmployeeDetails updateEmployeeDetails(EmployeeDetails employeeDetails) throws Exception;
	
	public void deleteEmployeeDetails(Integer employeeDetailsId);
	
	public List<EmployeeDetails> getAllEmployeeDetails();
	
	public EmployeeDetails getByEmployeeDetailsId(Integer employeeDetailsId);
	
	public List<EmployeeDetails> getAllEmployeesByRollName(String rollName);
	
	public List<EmployeeDetails> getAllEmployeeDetailsByProjectName(String projectName);
	
	public List<EmployeeDetails> getAllEmployeesByRollAndProjectName(String rollName, String projectName);
}
