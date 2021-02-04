package com.emp.serviceimpl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.model.ProjectDetailsModel;
import com.emp.repo.ProjectDetailsRepository;
import com.emp.service.ProjectDetailsService;

@Service
public class ProjectDetailsServiceImpl implements ProjectDetailsService {

	
	@Autowired
	ProjectDetailsRepository projectDetailsRepo;
	
	@Override
	public ProjectDetailsModel saveProjectDetails(ProjectDetailsModel projectDetails) {
		projectDetails = projectDetailsRepo.save(projectDetails);
		return projectDetails;
	}

	@Override
	public ProjectDetailsModel updateProjectDetails(ProjectDetailsModel projectDetails) throws Exception {
		ProjectDetailsModel projectDetailsRes = projectDetailsRepo.findById(projectDetails.getProjectId()).get();
//		System.out.println("in update method");
		if (Objects.isNull(projectDetailsRes)) {
			throw new Exception("Data not found");
		}
		projectDetailsRes = projectDetailsRepo.save(projectDetails);
		return projectDetailsRes;
	}

	@Override
	public void deleteProjectDetails(Integer projectId) {
		projectDetailsRepo.deleteById(projectId);

	}

	@Override
	public List<ProjectDetailsModel> getAllProjectDetails() {
		List<ProjectDetailsModel> projectDetails = projectDetailsRepo.findAll();
		return projectDetails;
	}

	@Override
	public ProjectDetailsModel getProjectDetailsById(Integer projectId) {
		ProjectDetailsModel projectDetails = projectDetailsRepo.findById(projectId).get();
		return projectDetails;
	}

}
