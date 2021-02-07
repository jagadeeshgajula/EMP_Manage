package com.emp.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
	@PostMapping("/savePayslips")
	public EmployeePayslipsModel savePayslips(@RequestBody EmployeePayslipsModel empPayslips) {
		empPayslips = empPayslipsService.savePayslips(empPayslips);
		return empPayslips;
	}

	// checks if the record exists if so then update the old record and return
	// updated record
	@PutMapping("/updatePayslips")
	public EmployeePayslipsModel updatePayslips(@RequestBody EmployeePayslipsModel empPayslips) throws Exception {
		empPayslips = empPayslipsService.updatePayslips(empPayslips);
		return empPayslips;
	}

	// delete the payslip by id
	@DeleteMapping("/deletePayslips")
	public void deletePayslips(@RequestParam Integer id) {
		empPayslipsService.deletePayslips(id);
	}

	// return all records
	@GetMapping("/getAll")
	public List<EmployeePayslipsModel> getAllPayslips() {
		List<EmployeePayslipsModel> empPayslips = empPayslipsService.getAllPayslips();
		return empPayslips;
	}

	// return specific payslip details by Id
	@GetMapping("/getById")
	public EmployeePayslipsModel getPayslipsById(@RequestParam Integer id) {
		EmployeePayslipsModel empPayslips = empPayslipsService.getPayslipsById(id);
		return empPayslips;
	}
	
	@GetMapping("/getEmployeePaySlipsByEmployeeId")
	public List<EmployeePayslipsModel> getEmployeePaySlipsByEmployeeId(@RequestParam Integer empId) {
		List<EmployeePayslipsModel> empPayslips = empPayslipsService.getEmployeePaySlipsByEmployeeId(empId);
		return empPayslips;
	}
	
	@GetMapping("/getEmployeePayslipsByGivenDate")
	public List<EmployeePayslipsModel> getEmployeePayslipsByGivenDate(@RequestParam("payslipDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate payslipDate) {
		List<EmployeePayslipsModel> empPayslips = empPayslipsService.getEmployeePayslipsByGivenDate(payslipDate);
		return empPayslips;
	}
	
	@GetMapping("/getEmployeePaySlipsByFromDateAndToDate")
	public List<EmployeePayslipsModel> getEmployeePaySlipsByFromDateAndToDate(@RequestParam("fromDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate, 
																			  @RequestParam("toDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate toDate) {
		List<EmployeePayslipsModel> empPayslips = empPayslipsService.getEmployeePaySlipsByFromDateAndToDate(fromDate, toDate);
		return empPayslips;
	}

}
