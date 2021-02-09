package com.emp.serviceimpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.dto.EmployeeSearchParamsDTO;
import com.emp.model.EmployeeDetails;
import com.emp.repo.EmployeeDetailsRepository;
import com.emp.service.EmployeeDetailsService;

@Service
public class EmployeeDetailsServiceImple implements EmployeeDetailsService {

	@Autowired
	EmployeeDetailsRepository employeeDetailsRepository;

	@PersistenceContext
	private EntityManager em;

	@Override
	public EmployeeDetails saveEmployeeDetails(EmployeeDetails employeeDetails) {
		employeeDetails = employeeDetailsRepository.save(employeeDetails);
		return employeeDetails;
	}

	@Override
	public EmployeeDetails updateEmployeeDetails(EmployeeDetails employeeDetails) throws Exception {
		EmployeeDetails employeeDetailsRes = employeeDetailsRepository.findById(employeeDetails.getEmployeeId()).get();
		if (Objects.isNull(employeeDetailsRes)) {
			throw new Exception("Data Not Found");
		}

		employeeDetailsRes = employeeDetailsRepository.save(employeeDetails);

		return employeeDetailsRes;
	}

	@Override
	public void deleteEmployeeDetails(Integer employeeDetailsId) {
		employeeDetailsRepository.deleteById(employeeDetailsId);
	}

	@Override
	public List<EmployeeDetails> getAllEmployeeDetails() {

		return employeeDetailsRepository.findAll();
	}

	@Override
	public EmployeeDetails getByEmployeeDetailsId(Integer employeeDetailsId) {

		return employeeDetailsRepository.findById(employeeDetailsId).get();
	}

	@Override
	public List<EmployeeDetails> getAllEmployeesByRollName(String roleName) {
		List<EmployeeDetails> empList = employeeDetailsRepository.getAllEmployeesByRollName(roleName);
		return empList;
	}

	@Override
	public List<EmployeeDetails> getAllEmployeeDetailsByProjectName(String projectName) {
		List<EmployeeDetails> empList = employeeDetailsRepository.getAllEmployeeDetailsByProjectName(projectName);
		return empList;
	}

	@Override
	public List<EmployeeDetails> getAllEmployeesByRollAndProjectName(String roleName, String projectName) {
		List<EmployeeDetails> empList = employeeDetailsRepository.getAllEmployeesByRollAndProjectName(roleName,
				projectName);
		return empList;
	}

	@Override
	public List<EmployeeDetails> serachEmployees(EmployeeSearchParamsDTO searchParams) {
		System.out.println(searchParams.toString());
		String baseSQL = "SELECT e FROM employee_details e";
		String whereCluse = "";
		
		if (Objects.nonNull(searchParams)) {
			if (Objects.nonNull(searchParams.getFirstName())) {

				// to check first Name condition
				if (whereCluse.equals("")) {
					whereCluse = " where e.firstName like '%" + searchParams.getFirstName() + "%'";
				} else {
					whereCluse += " and e.firstName like '%" + searchParams.getFirstName() + "%'";
				}
			}

			if (Objects.nonNull(searchParams.getLastName())) {
				if (whereCluse.equals("")) {
					whereCluse = " where e.lastName like '%" + searchParams.getLastName() + "%'";
				} else {
					whereCluse += " and e.lastName like '%" + searchParams.getLastName() + "%'";
				}
			}

			if (Objects.nonNull(searchParams.getPhoneNumber())) {
				if (whereCluse.equals("")) {
					whereCluse = " where e.phoneNumber =" + searchParams.getPhoneNumber();
				} else {
					whereCluse += " and e.phoneNumber = " + searchParams.getPhoneNumber();
				}
			}

			if (Objects.nonNull(searchParams.getDob())) {
				DateTimeFormatter formatters = null;
			    String text = null;
			    StringBuilder remove = null;
			    
				if (whereCluse.equals("")) {
					formatters = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				    text = searchParams.getDob().format(formatters);
				    remove= new StringBuilder(text);
				    remove.delete(4,5);
				    remove.delete(6,7);
				    System.out.println(remove);
					whereCluse = " where e.dob = " + remove;
				} else {
					formatters = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				    text = searchParams.getDob().format(formatters);
				    remove= new StringBuilder(text);
				    remove.delete(4,5);
				    remove.delete(6,7);
					whereCluse += " and e.dob = " + remove;
				}
			}
		}

		if (!whereCluse.equals("")) {
			baseSQL += whereCluse;
		}

		List<EmployeeDetails> empList = em.createQuery(baseSQL).getResultList();

		return empList;
	}

}
