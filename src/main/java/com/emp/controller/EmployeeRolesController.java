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

import com.emp.model.EmployeeDetails;
import com.emp.model.EmployeeRoles;
import com.emp.service.EmployeeRolesService;

@RestController
@CrossOrigin
public class EmployeeRolesController {

	@Autowired
	EmployeeRolesService employeeRolesService;
	
	@PostMapping("/saveEmployeeRoll")
	public EmployeeRoles saveEmployeeRoll(@RequestBody EmployeeRoles employeeRole) {
		employeeRole = employeeRolesService.saveEmployeeRol(employeeRole);
		return employeeRole;
	}
	
	@PutMapping("/updateEmployeeRoll")
	public EmployeeRoles updateEmployeeRoll(@RequestBody EmployeeRoles employeeRole) throws Exception {
		employeeRole = employeeRolesService.updateEmployeeRol(employeeRole);
		return employeeRole;
	}
	
	@DeleteMapping("/deleteEmployeeRoll")
	public void deleteEmployeeRoll(@RequestParam Integer employeeRoleId) {
		employeeRolesService.deleteEmployeeRol(employeeRoleId);
	}
	
	@GetMapping("/getAllEmployeeRolls")
	public List<EmployeeRoles> getAllEmployeeRolls() {
		List<EmployeeRoles> employeeRollsList = employeeRolesService.getAllEmployeeRolls();
		return employeeRollsList;
	}
	
	@GetMapping("/getEmployeeRollById")
	public EmployeeRoles getEmployeeRollById(@RequestParam Integer employeeRoleId) {
		EmployeeRoles employeeRoll = employeeRolesService.getByEmployeeRollId(employeeRoleId);
		return employeeRoll;
	}
	
//	@GetMapping("/getAllEmployeesByRollName")
//	public List<EmployeeDetails> getAllEmployeesByRollName(@RequestParam EmployeeRoles rollName) {
//		return ((EmployeeRolesController) employeeRolesService).getAllEmployeesByRollName(rollName);
//		
//	}
}
