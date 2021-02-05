package com.emp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.emp.model.EmployeeDetails;
import com.emp.model.EmployeeRoles;

public interface EmployeeDetailsRepository extends JpaRepository<EmployeeDetails, Integer> {

	@Query("select emp from employee_details emp inner join rol_details r on emp.employeeRole.roleId = r.roleId where r.roleName= :rollName")
	List<EmployeeDetails> getAllEmployeesByRollName(@Param("rollName") String rollName);

	
	@Query("select emp from employee_details emp inner join project_details p on emp.projectDetail.projectId = p.projectId where p.projectName= :projectName")
	List<EmployeeDetails> getAllEmployeeDetailsByProjectName(String projectName);

	@Query("select emp from employee_details emp inner join rol_details r on emp.employeeRole.roleId = r.roleId "
			+ "and project_details p on emp.projectDetail.projectId = p.projectId where r.roleName= :rollName and where p.projectName= :projectName)")
	List<EmployeeDetails> getAllEmployeesByRollAndProjectName(String rollName, String projectName);

}
