package com.ankit.service;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ankit.model.Employee;
import com.ankit.repository.IEmployeeManagementRepo;

@Service
public class EmployeeManagementServiceImpl implements IEmployeeManagementService {
	@Autowired
	private IEmployeeManagementRepo empRepo;
	@Override
	public Page<Employee> showEmployeePageData(Pageable pageable) {
		
		return empRepo.findAll(pageable);
	}

	@Override
	public String registerEmployee(Employee employee) {
		return empRepo.save(employee).getId() + " Employee No Registered(Added) Successfully";
	}

	@Override
	public Employee getEmployeeById(int id) {
		Employee emp = empRepo.findById(id).get();
		return emp;
	}

	@Override
	public String editEmployee(Employee employee) {

		return empRepo.save(employee).getId() + " Employee No Updated(Edited) Successfully";
	}

	@Override
	public String deleteEmployeeById(int id) {
		empRepo.deleteById(id);
		return id+" Employee No Deleted Successfully";
	}
	@Override
	public Set<String> countryNames() {
		Locale[] locales = Locale.getAvailableLocales();
		Set<String> countries=new TreeSet();
		for(Locale l:locales)
		{
			if(l!=null)
			{
				countries.add(l.getDisplayCountry());
			}
		}
		return countries;
	}
	@Autowired
	private Environment env;
	@Override
	public List<String> stateNames(String country) {
		String stateInfo = env.getRequiredProperty(country);
		List<String>states=Arrays.asList(stateInfo.split(","));
		return states;
	}
}
