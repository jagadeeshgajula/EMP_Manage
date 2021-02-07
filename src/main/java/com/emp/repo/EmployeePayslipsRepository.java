package com.emp.repo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.emp.model.EmployeePayslipsModel;

public interface EmployeePayslipsRepository extends JpaRepository<EmployeePayslipsModel,Integer> {

	@Query("select ps from employee_payslips ps inner join employee_details emp on ps.employeeDetail.employeeId = emp.employeeId where emp.employeeId = :empId")
	 List<EmployeePayslipsModel> getEmployeePaySlipsByEmployeeId(Integer empId);

	
//	List<EmployeePayslipsModel> getEmployeePayslipsByGivenDate(LocalDate date);

	@Query("select ps from employee_payslips ps where ps.payslipDate = :payslipDate")
	List<EmployeePayslipsModel> findByDate(LocalDate payslipDate);

	@Query("select ps from employee_payslips ps where(ps.payslipDate BETWEEN :fromDate AND :toDate)")
	List<EmployeePayslipsModel> findByFromDateToDate(LocalDate fromDate, LocalDate toDate);

}
