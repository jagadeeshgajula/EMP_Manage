package com.emp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.model.EmployeePayslipsModel;

public interface EmployeePayslipsRepository extends JpaRepository<EmployeePayslipsModel,Integer> {

}
