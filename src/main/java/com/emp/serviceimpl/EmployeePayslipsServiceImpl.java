package com.emp.serviceimpl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.model.EmployeePayslipsModel;
import com.emp.repo.EmployeePayslipsRepository;
import com.emp.service.EmployeePayslipsService;

@Service
public class EmployeePayslipsServiceImpl implements EmployeePayslipsService {

	// create the instance of the object for the given repo singleton design pattern
	@Autowired
	private EmployeePayslipsRepository empPayslipsRepo;
	
	//save employee payslip details object and return saved record with auto incremented primary key:id
	@Override
	public EmployeePayslipsModel savePayslips(EmployeePayslipsModel empPayslips) {
		empPayslips = empPayslipsRepo.save(empPayslips);
		return empPayslips;
	}
	
	//checks if the record exists if so then update the old record and return updated record
	@Override
	public EmployeePayslipsModel updatePayslips(EmployeePayslipsModel empPayslips) throws Exception {
		empPayslips = empPayslipsRepo.getOne(empPayslips.getPayslipId());
		if(Objects.isNull(empPayslips)) {
			
			throw new Exception("Data not found");
	}
		empPayslipsRepo.save(empPayslips);
		return empPayslips;
	}

	//delete the payslip by id
	@Override
	public void deletePayslips(Integer id) {
		empPayslipsRepo.deleteById(id);
	}
	
	//return all records
	@Override
	public List<EmployeePayslipsModel> getAllPayslips() {
		List<EmployeePayslipsModel> empPayslips = empPayslipsRepo.findAll();
		return empPayslips;
	}

	//return specific payslip details by Id
	@Override
	public EmployeePayslipsModel getPayslipsById(Integer id) {
		EmployeePayslipsModel empPayslips = empPayslipsRepo.getOne(id);
		return empPayslips;
	}

}
