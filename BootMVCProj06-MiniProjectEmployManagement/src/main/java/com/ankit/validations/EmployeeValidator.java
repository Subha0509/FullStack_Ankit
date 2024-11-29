package com.ankit.validations;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ankit.model.Employee;
@Component
public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(Employee.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Employee emp=(Employee)target;
		String name=emp.getName();
		if(name==null||name.length()==0)
			errors.rejectValue("name", "empname.required");
		else if(name.length()>20)
			errors.rejectValue("name", "empname.maxlength");
		String profile=emp.getProfile();
		if(profile==null||profile.length()==0)
			errors.rejectValue("profile", "empprofile.required");
		else if(profile.length()>20)
			errors.rejectValue("profile", "empprofile.maxlength");
		Double salary=emp.getSalary();
		if(salary==null)
			errors.rejectValue("salary", "empsalary.required");
		else if(salary<0||salary>200000)
			errors.rejectValue("salary","empsalary.range");
	}

}
