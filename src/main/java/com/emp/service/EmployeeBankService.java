package com.emp.service;

import java.util.List;

import com.emp.model.EmployeeBankModel;

public interface EmployeeBankService {
	
	//save employee bank details object and return saved record with auto incremented primary key:id
	public EmployeeBankModel saveBankDetails(EmployeeBankModel employeeBankDetails);
	
	//update employee bank details and return updated record
	public EmployeeBankModel updateBankDetails(EmployeeBankModel employeeBankDetails);

	//delete employee bank details by Id
	public void deleteBankDetails(Integer id);

	//return all records
	public List<EmployeeBankModel> getAllBankDetails();

	//return specific bank details by Id
	public EmployeeBankModel getBankDetailsById(Integer id);

}
