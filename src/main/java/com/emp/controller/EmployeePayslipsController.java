package com.emp.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emp.model.EmployeePayslipsModel;
import com.emp.service.EmployeePayslipsService;

@RestController
public class EmployeePayslipsController {

	@Autowired
	EmployeePayslipsService empPayslipsService;

	// save employee payslip details object and return saved record with auto
	// incremented primary key:id
	@PostMapping("/savepayslips")
	public EmployeePayslipsModel savePayslips(@RequestBody EmployeePayslipsModel empPayslips) {
		empPayslips = empPayslipsService.savePayslips(empPayslips);
		return empPayslips;
	}

	// checks if the record exists if so then update the old record and return
	// updated record
	@PutMapping("/updatepayslips")
	public EmployeePayslipsModel updatePayslips(@RequestBody EmployeePayslipsModel empPayslips) throws Exception {
		empPayslipsService.updatePayslips(empPayslips);
		return empPayslips;
	}

	// delete the payslip by id
	@DeleteMapping("/deletepayslips")
	public void deletePayslips(@RequestParam Integer id) {
		empPayslipsService.deletePayslips(id);
	}

	// return all records
	@GetMapping("/getall")
	public List<EmployeePayslipsModel> getAllPayslips() {
		List<EmployeePayslipsModel> empPayslips = empPayslipsService.getAllPayslips();
		return empPayslips;
	}

	// return specific payslip details by Id
	@GetMapping("/getbyid")
	public EmployeePayslipsModel getPayslipsById(@RequestParam Integer id) {
		EmployeePayslipsModel empPayslips = empPayslipsService.getPayslipsById(id);
		return empPayslips;
	}

}
