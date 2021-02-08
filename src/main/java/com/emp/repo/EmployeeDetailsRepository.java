package com.emp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.emp.model.EmployeeDetails;

public interface EmployeeDetailsRepository extends JpaRepository<EmployeeDetails, Integer> {

	@Query("select emp from employee_details emp inner join rol_details r on emp.employeeRole.roleId = r.roleId where r.roleName= :roleName")
	List<EmployeeDetails> getAllEmployeesByRollName(@Param("roleName") String roleName);

	
	@Query("select emp from employee_details emp inner join project_details pd on emp.projectDetail.projectId = pd.projectId where pd.projectName = :projectName")
	List<EmployeeDetails> getAllEmployeeDetailsByProjectName(String projectName);

	@Query("select emp from employee_details emp inner join rol_details r on emp.employeeRole.roleId = r.roleId inner join project_details pd on emp.projectDetail.projectId = pd.projectId where (r.roleName= :roleName and pd.projectName = :projectName)")
	List<EmployeeDetails> getAllEmployeesByRollAndProjectName(String roleName, String projectName);

}
