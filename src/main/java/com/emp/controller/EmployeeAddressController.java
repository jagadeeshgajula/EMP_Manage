package com.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emp.model.EmployeeAddress;
import com.emp.service.EmployeeAddressService;

@RestController
@CrossOrigin
public class EmployeeAddressController {

	@Autowired
	EmployeeAddressService employeeAddressService;
	
	@PostMapping("/saveEmployeeAddress")
	public EmployeeAddress saveEmployeeAddress(@RequestBody EmployeeAddress employeeAddress) {
		employeeAddress = employeeAddressService.saveEmployeeAddress(employeeAddress);
		return employeeAddress;
	}
	
	@PutMapping("/updateEmployeeAddress")
	public EmployeeAddress updateEmployeeAddress(@RequestBody EmployeeAddress employeeAddress) throws Exception {
		employeeAddress = employeeAddressService.updateEmployeeAddress(employeeAddress);
		return employeeAddress;
	}
	
	@DeleteMapping("/deleteEmployeeAddress")
	public void deleteEmployeeAddress(@RequestParam Integer employeeAddressId) {
		employeeAddressService.deleteEmployeeAddress(employeeAddressId);
	}
	
	@GetMapping("/getAllEmployeeAddress")
	public List<EmployeeAddress> getAllEmployeeAddresss() {
		List<EmployeeAddress> employeeAddresssList = employeeAddressService.getAllEmployeeAddress();
		return employeeAddresssList;
	}
	
	@GetMapping("/getEmployeeAddressById")
	public EmployeeAddress getEmployeeAddressById(@RequestParam Integer employeeAddressId) {
		EmployeeAddress employeeAddress = employeeAddressService.getByEmployeeAddressId(employeeAddressId);
		return employeeAddress;
	}
	
	@GetMapping("/getEmployeeAddressByEmployeeId")
	public List<EmployeeAddress> getEmployeeAddressByEmployeeId(@RequestParam Integer empId) {
		List<EmployeeAddress> employeeAddress = employeeAddressService.getEmployeeAddressByEmployeeId(empId);
		return employeeAddress;
	}
}
