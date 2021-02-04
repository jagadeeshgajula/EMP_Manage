package com.emp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity(name="project_details")
@Data
public class ProjectDetailsModel {
	
	@Id
	@Column(name="project_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer projectId;
	
	@Column(name="project_name")
	String projectName;
	
	@Column(name="project_description")
	String projectDescription;
	
}
