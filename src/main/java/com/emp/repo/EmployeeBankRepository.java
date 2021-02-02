package com.emp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.model.EmployeeBankModel;

public interface EmployeeBankRepository extends JpaRepository<EmployeeBankModel, Integer> {

}
