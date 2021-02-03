package com.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.emp.model.EmployeeBankModel;
import com.emp.service.EmployeeBankService;

@RestController
public class EmployeeBankController {

	@Autowired
	EmployeeBankService empBankService;

	// save employee bank details object and return saved record with auto
	// incremented primary key:id
	@PostMapping("/savebank")
	public EmployeeBankModel saveBank(@RequestBody EmployeeBankModel empBank) {
		empBank = empBankService.saveBankDetails(empBank);
		return empBank;
	}

	// checks if the record exists if so then update the old record and return
	// updated record
	@PutMapping("/updatebank")
	public EmployeeBankModel updateBank(@RequestBody EmployeeBankModel empBank) throws Exception {
		empBank = empBankService.updateBankDetails(empBank);
		return empBank;
	}

	// delete the bank by id
	@DeleteMapping("/deletebank")
	public void deleteBankDetails(@RequestParam Integer id) {
		empBankService.deleteBankDetails(id);

	}

	// return all records
	@GetMapping("/getallbanks")
	public List<EmployeeBankModel> getAllBankDetails() {
		List<EmployeeBankModel> empBank = empBankService.getAllBankDetails();
		return empBank;
	}

	// return specific bank details by Id
	@GetMapping("/getbankbyid")
	public EmployeeBankModel getBankDetailsById(@RequestParam Integer id) {
		EmployeeBankModel empBank = empBankService.getBankDetailsById(id);
		return empBank;
	}

}
