package com.emp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.model.EmployeeDetails;

public interface EmployeeDetailsRepository extends JpaRepository<EmployeeDetails, Integer> {

}
