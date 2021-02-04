package com.emp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.model.ProjectDetailsModel;

public interface ProjectDetailsRepository extends JpaRepository<ProjectDetailsModel, Integer> {

}
