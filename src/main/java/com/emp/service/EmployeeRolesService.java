package com.emp.service;

import java.util.List;

import com.emp.model.EmployeeRoles;

public interface EmployeeRolesService {

	
	public EmployeeRoles saveEmployeeRol(EmployeeRoles employeeRole);
	
	public EmployeeRoles updateEmployeeRol(EmployeeRoles employeeRole) throws Exception;
	
	public void deleteEmployeeRol(Integer employeeRoleId);
	
	public List<EmployeeRoles> getAllEmployeeRolls();
	
	public EmployeeRoles getByEmployeeRollId(Integer employeeRoleId);
}
