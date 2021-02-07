package com.emp.serviceimpl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.model.EmployeeRoles;
import com.emp.repo.EmployeeRolesRepository;
import com.emp.service.EmployeeRolesService;

@Service
public class EmployeeRolesServiceImple implements EmployeeRolesService {

	@Autowired
	EmployeeRolesRepository employeeRolesRepository;
	
	@Override
	public EmployeeRoles saveEmployeeRol(EmployeeRoles employeeRole) {
		employeeRole = employeeRolesRepository.save(employeeRole);
		return employeeRole;
	}

	@Override
	public EmployeeRoles updateEmployeeRol(EmployeeRoles employeeRole) throws Exception {
		EmployeeRoles employeeRoleRes = employeeRolesRepository.findById(employeeRole.getRoleId()).get();
		if(Objects.isNull(employeeRoleRes))
		{
			throw new Exception("Data Not Found");
		}
		
		employeeRoleRes = employeeRolesRepository.save(employeeRole);
		
		return employeeRoleRes;
	}

	@Override
	public void deleteEmployeeRol(Integer employeeRoleId) {
		employeeRolesRepository.deleteById(employeeRoleId);
	}

	@Override
	public List<EmployeeRoles> getAllEmployeeRolls() {
		// TODO Auto-generated method stub
		return employeeRolesRepository.findAll();
	}

	@Override
	public EmployeeRoles getByEmployeeRollId(Integer employeeRoleId) {
		
		return employeeRolesRepository.findById(employeeRoleId).get();
	}

}
