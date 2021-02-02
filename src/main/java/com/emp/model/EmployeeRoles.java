package com.emp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity(name="rol_details")
@Data
public class EmployeeRoles {

	@Id
	@Column(name="rol_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer roleId;
	
	@Column(name="rol_name")
	String roleName;
	
	@Column(name="rol_description")
	String roleDescription;
}

