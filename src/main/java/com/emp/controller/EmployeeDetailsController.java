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

import com.emp.dto.EmployeeSearchParamsDTO;
import com.emp.model.EmployeeDetails;
import com.emp.service.EmployeeDetailsService;

@RestController
@CrossOrigin
public class EmployeeDetailsController {

	@Autowired
	EmployeeDetailsService employeeDetailsService;
	
	@PostMapping("/saveEmployeeDetails")
	public EmployeeDetails saveEmployeeDetails(@RequestBody EmployeeDetails employeeDetail) {
		employeeDetail = employeeDetailsService.saveEmployeeDetails(employeeDetail);
		return employeeDetail;
	}
	
	@PutMapping("/updateEmployeeDetails")
	public EmployeeDetails updateEmployeeDetails(@RequestBody EmployeeDetails employeeDetail) throws Exception {
		employeeDetail = employeeDetailsService.updateEmployeeDetails(employeeDetail);
		return employeeDetail;
	}
	
	@DeleteMapping("/deleteEmployeeDetails")
	public void deleteEmployeeDetails(@RequestParam Integer employeeDetailId) {
		employeeDetailsService.deleteEmployeeDetails(employeeDetailId);
	}
	
	@GetMapping("/getAllEmployeeDetails")
	public List<EmployeeDetails> getAllEmployeeDetailss() {
		List<EmployeeDetails> EmployeeDetailssList = employeeDetailsService.getAllEmployeeDetails();
		return EmployeeDetailssList;
	}
	
	@GetMapping("/getEmployeeDetailsById")
	public EmployeeDetails getEmployeeDetailsById(@RequestParam Integer employeeDetailId) {
		EmployeeDetails EmployeeDetails = employeeDetailsService.getByEmployeeDetailsId(employeeDetailId);
		return EmployeeDetails;
	}
	
	@GetMapping("/getAllEmployeesByRollName")
	public List<EmployeeDetails> getAllEmployeesByRollName(@RequestParam String rollName) {
		return employeeDetailsService.getAllEmployeesByRollName(rollName);
		
	}
	
	@GetMapping("/getAllEmployeeDetailsByProjectName")
	public List<EmployeeDetails> getAllEmployeeDetailsByProjectName(@RequestParam String projectName) {
		return employeeDetailsService.getAllEmployeeDetailsByProjectName(projectName);
		
	}
	
	@GetMapping("/getAllEmployeesByRollAndProjectName")
	public List<EmployeeDetails> getAllEmployeesByRollAndProjectName(@RequestParam String rollName, String projectName) {
		return employeeDetailsService.getAllEmployeesByRollAndProjectName(rollName, projectName);
		
	}
	
	@PostMapping("/searchEmployeeDetails")
	public List<EmployeeDetails> searchEmployeeDetails(@RequestBody EmployeeSearchParamsDTO searchParams) {
		List<EmployeeDetails> empList = employeeDetailsService.serachEmployees(searchParams);
		return empList;
	}
}
