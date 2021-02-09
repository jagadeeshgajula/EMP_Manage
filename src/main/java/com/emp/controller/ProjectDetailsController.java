package com.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emp.model.ProjectDetailsModel;
import com.emp.service.ProjectDetailsService;

@RestController
@CrossOrigin
public class ProjectDetailsController {

	
	@Autowired
	ProjectDetailsService projectDetailsService;

	// save employee project details object and return saved record with auto
	// incremented primary key:id
	@PostMapping("/saveproject")
	public ProjectDetailsModel saveproject(@RequestBody ProjectDetailsModel project) {
		project = projectDetailsService.saveProjectDetails(project);
		return project;
	}

	// checks if the record exists if so then update the old record and return
	// updated record
	@PutMapping("/updateproject")
	public ProjectDetailsModel updateproject(@RequestBody ProjectDetailsModel project) throws Exception {
		project = projectDetailsService.updateProjectDetails(project);
		return project;
	}

	// delete the project by id
	@DeleteMapping("/deleteproject")
	public void deleteprojectDetails(@RequestParam Integer id) {
		projectDetailsService.deleteProjectDetails(id);

	}

	// return all records
	@GetMapping("/getallprojects")
	public List<ProjectDetailsModel> getAllprojectDetails() {
		List<ProjectDetailsModel> project = projectDetailsService.getAllProjectDetails();
		return project;
	}

	// return specific project details by Id
	@GetMapping("/getprojectbyid")
	public ProjectDetailsModel getprojectDetailsById(@RequestParam Integer id) {
		ProjectDetailsModel project = projectDetailsService.getProjectDetailsById(id);
		return project;
	}

}
