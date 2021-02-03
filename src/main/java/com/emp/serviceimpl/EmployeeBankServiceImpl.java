package com.emp.serviceimpl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.model.EmployeeBankModel;
import com.emp.repo.EmployeeBankRepository;
import com.emp.service.EmployeeBankService;

@Service
public class EmployeeBankServiceImpl implements EmployeeBankService {

	// create the instance of the object for the given repo singleton design pattern
	@Autowired
	private EmployeeBankRepository empBankRepo;

	// save employee bank details object and return saved record with auto
	// incremented primary key:id
	@Override
	public EmployeeBankModel saveBankDetails(EmployeeBankModel empBank) {
		empBank = empBankRepo.save(empBank);
		return empBank;
	}

	// checks if the record exists if so then update the old record and return
	// updated record
	@Override
	public EmployeeBankModel updateBankDetails(EmployeeBankModel empBank) throws Exception {
		EmployeeBankModel empBankRes = empBankRepo.findById(empBank.getEmployeeBankId()).get();
		System.out.println("in update method");
		if (Objects.isNull(empBankRes)) {
			throw new Exception("Data not found");
		}
		empBankRes = empBankRepo.save(empBank);
		return empBankRes;
	}

	// delete the bank by id
	@Override
	public void deleteBankDetails(Integer id) {
		empBankRepo.deleteById(id);

	}

	// return all records
	@Override
	public List<EmployeeBankModel> getAllBankDetails() {
		List<EmployeeBankModel> empBank = empBankRepo.findAll();
		return empBank;
	}

	// return specific bank details by Id
	@Override
	public EmployeeBankModel getBankDetailsById(Integer id) {
		EmployeeBankModel empBank = empBankRepo.findById(id).get();
		return empBank;
	}

}
