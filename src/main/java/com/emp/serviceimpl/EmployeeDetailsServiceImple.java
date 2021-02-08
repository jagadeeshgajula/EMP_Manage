package com.emp.serviceimpl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.model.EmployeeDetails;
import com.emp.model.EmployeeRoles;
import com.emp.repo.EmployeeDetailsRepository;
import com.emp.service.EmployeeDetailsService;

@Service
public class EmployeeDetailsServiceImple implements EmployeeDetailsService {

	@Autowired
	EmployeeDetailsRepository employeeDetailsRepository;
	
	@Override
	public EmployeeDetails saveEmployeeDetails(EmployeeDetails employeeDetails) {
		employeeDetails = employeeDetailsRepository.save(employeeDetails);
		return employeeDetails;
	}

	@Override
	public EmployeeDetails updateEmployeeDetails(EmployeeDetails employeeDetails) throws Exception {
		EmployeeDetails employeeDetailsRes = employeeDetailsRepository.findById(employeeDetails.getEmployeeId()).get();
		if(Objects.isNull(employeeDetailsRes))
		{
			throw new Exception("Data Not Found");
		}
		
		employeeDetailsRes = employeeDetailsRepository.save(employeeDetails);
		
		return employeeDetailsRes;
	}

	@Override
	public void deleteEmployeeDetails(Integer employeeDetailsId) {
		employeeDetailsRepository.deleteById(employeeDetailsId);
	}

	@Override
	public List<EmployeeDetails> getAllEmployeeDetails() {
	
		return employeeDetailsRepository.findAll();
	}

	@Override
	public EmployeeDetails getByEmployeeDetailsId(Integer employeeDetailsId) {
		
		return employeeDetailsRepository.findById(employeeDetailsId).get();
	}

	@Override
	public List<EmployeeDetails> getAllEmployeesByRollName(String roleName) {
		List<EmployeeDetails> empList = employeeDetailsRepository.getAllEmployeesByRollName(roleName);
		return empList;
	}

	@Override
	public List<EmployeeDetails> getAllEmployeeDetailsByProjectName(String projectName) {
		List<EmployeeDetails> empList = employeeDetailsRepository.getAllEmployeeDetailsByProjectName(projectName);
		return empList;
	}

	@Override
	public List<EmployeeDetails> getAllEmployeesByRollAndProjectName(String roleName, String projectName) {
		List<EmployeeDetails> empList = employeeDetailsRepository.getAllEmployeesByRollAndProjectName(roleName, projectName);
		return empList;
	}

}
