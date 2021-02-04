package com.emp.service;

import java.util.List;

import com.emp.model.ProjectDetailsModel;

public interface ProjectDetailsService {

	//save employee payslip details object and return saved record with auto incremented primary key:id
	public ProjectDetailsModel saveProjectDetails(ProjectDetailsModel projectDetails);
	
	//update employee payslip details and return updated record
	public ProjectDetailsModel updateProjectDetails(ProjectDetailsModel projectDetails) throws Exception;

	//delete employee payslip details by Id
	public void deleteProjectDetails(Integer projectId);

	//return all records
	public List<ProjectDetailsModel> getAllProjectDetails();

	//return specific payslip details by Id
	public ProjectDetailsModel getProjectDetailsById(Integer projectId);

}
