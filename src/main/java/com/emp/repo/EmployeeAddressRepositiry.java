package com.emp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.model.EmployeeAddress;
import com.emp.model.EmployeeDetails;

public interface EmployeeAddressRepositiry extends JpaRepository<EmployeeAddress, Integer> {

	List<EmployeeAddress> findByEmployeeId(EmployeeDetails empDetail);

}
