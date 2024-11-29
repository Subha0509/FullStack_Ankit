package com.ankit.service;



import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ankit.model.Employee;

public interface IEmployeeManagementService {
	public Page<Employee> showEmployeePageData(Pageable pageable);
	public String registerEmployee(Employee employee);
	public Employee getEmployeeById(int id);
	public String editEmployee(Employee employee);
	public String deleteEmployeeById(int id);
	public Set<String> countryNames();
	public List<String> stateNames(String country);
	
}
