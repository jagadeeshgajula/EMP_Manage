package com.emp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity(name="employee_bank_details") 
@Data
public class EmployeeBankModel {
	
	@Id
	@Column(name="employee_bank_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer employeeBankId;
	
	@Column(name="bank_name")
	String bankName;
	
	@Column(name="bank_account_no")
	String bankAccountNo;
	
	@Column(name="acccount_type")
	String accountType;
	

}
