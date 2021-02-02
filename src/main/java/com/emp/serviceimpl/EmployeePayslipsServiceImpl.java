package com.emp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.emp.model.EmployeePayslipsModel;
import com.emp.repo.EmployeePayslipsRepository;
import com.emp.service.EmployeePayslipsService;

public class EmployeePayslipsServiceImpl implements EmployeePayslipsService {

	@Autowired
	private EmployeePayslipsRepository empPayslipsRepo;
	
	@Override
	public EmployeePayslipsModel savePayslips(EmployeePayslipsModel empPayslips) {
		empPayslips = empPayslipsRepo.save(empPayslips);
		return empPayslips;
	}

	@Override
	public EmployeePayslipsModel updatePayslips(EmployeePayslipsModel empPayslips) {
		empPayslips = empPayslipsRepo.save(empPayslips);
		return empPayslips;
	}

	@Override
	public void deletePayslips(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<EmployeePayslipsModel> getAllPayslips() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeePayslipsModel getPayslipsById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
