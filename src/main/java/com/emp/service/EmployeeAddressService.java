package com.emp.service;

import java.util.List;

import com.emp.model.EmployeeAddress;

public interface EmployeeAddressService {

	
	public EmployeeAddress saveEmployeeAddress(EmployeeAddress employeeAddress);
	
	public EmployeeAddress updateEmployeeAddress(EmployeeAddress employeeAddress) throws Exception;
	
	public void deleteEmployeeAddress(Integer employeeAddressId);
	
	public List<EmployeeAddress> getAllEmployeeAddress();
	
	public EmployeeAddress getByEmployeeAddressId(Integer employeeAddressId);
	
	public List<EmployeeAddress> getEmployeeAddressByEmployeeId(Integer empId);
} 
