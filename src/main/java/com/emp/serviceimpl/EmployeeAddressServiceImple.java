package com.emp.serviceimpl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.model.EmployeeAddress;
import com.emp.model.EmployeeDetails;
import com.emp.repo.EmployeeAddressRepositiry;
import com.emp.service.EmployeeAddressService;

@Service
public class EmployeeAddressServiceImple implements EmployeeAddressService {

	@Autowired
	EmployeeAddressRepositiry employeeAddressRepositiry;
	
	@Override
	public EmployeeAddress saveEmployeeAddress(EmployeeAddress EmployeeAddress) {
		EmployeeAddress = employeeAddressRepositiry.save(EmployeeAddress);
		return EmployeeAddress;
	}

	@Override
	public EmployeeAddress updateEmployeeAddress(EmployeeAddress EmployeeAddress) throws Exception {
		EmployeeAddress EmployeeAddressRes = employeeAddressRepositiry.findById(EmployeeAddress.getAddressId()).get();
		if(Objects.isNull(EmployeeAddressRes))
		{
			throw new Exception("Data Not Found");
		}
		
		EmployeeAddressRes = employeeAddressRepositiry.save(EmployeeAddress);
		
		return EmployeeAddressRes;
	}

	@Override
	public void deleteEmployeeAddress(Integer EmployeeAddressId) {
		employeeAddressRepositiry.deleteById(EmployeeAddressId);
	}

	@Override
	public List<EmployeeAddress> getAllEmployeeAddress() {
	
		return employeeAddressRepositiry.findAll();
	}

	@Override
	public List<EmployeeAddress> getEmployeeAddressByEmployeeId(Integer empId) {
		EmployeeDetails empDetail = new EmployeeDetails();
		empDetail.setEmployeeId(empId);
		return employeeAddressRepositiry.findByEmployeeId(empDetail);
	}

}
