package com.emp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.model.EmployeeAddress;

public interface EmployeeAddressRepositiry extends JpaRepository<EmployeeAddress, Integer> {

}
