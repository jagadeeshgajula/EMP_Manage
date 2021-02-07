package com.emp.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity(name="employee_payslips")
@Data
public class EmployeePayslipsModel {
	
	@Id
	@Column(name="payslip_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer payslipId;
	
	@Column(name="basic")
	Double basic;
	
	@Column(name="hra")
	Double hra;
	
	@Column(name="pf")
	Double pf;
	
	@Column(name="gross_amount")
	double grossAmount;
	
	@Column(name="net_amount")
	double netAmount;
	
	@Column(name="payslip_date")
	LocalDate payslipDate;
	
//	Foreign Key
	@OneToOne
	@JoinColumn(name="employee_bank_id")
	EmployeeBankModel employeeBank;
	
//	Foreign Key
	@OneToOne
	@JoinColumn(name="employee_id")
	EmployeeDetails employeeDetail;

}
