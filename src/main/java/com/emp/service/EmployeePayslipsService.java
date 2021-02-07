package com.emp.service;

import java.time.LocalDate;
import java.util.List;

import com.emp.model.EmployeePayslipsModel;

public interface EmployeePayslipsService {

	
	//save employee payslip details object and return saved record with auto incremented primary key:id
	public EmployeePayslipsModel savePayslips(EmployeePayslipsModel employeePayslips);
	
	//update employee payslip details and return updated record
	public EmployeePayslipsModel updatePayslips(EmployeePayslipsModel employeePayslips) throws Exception;

	//delete employee payslip details by Id
	public void deletePayslips(Integer id);

	//return all records
	public List<EmployeePayslipsModel> getAllPayslips();

	//return specific payslip details by Id
	public EmployeePayslipsModel getPayslipsById(Integer id);
	
	public List<EmployeePayslipsModel> getEmployeePaySlipsByEmployeeId(Integer empId);
	
	public List<EmployeePayslipsModel> getEmployeePayslipsByGivenDate(LocalDate payslipDate);
	
	public List<EmployeePayslipsModel> getEmployeePaySlipsByFromDateAndToDate(LocalDate fromDate, LocalDate toDate);

}
