package com.ankit.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ankit.model.Employee;
import com.ankit.service.IEmployeeManagementService;
import com.ankit.validations.EmployeeValidator;

@Controller
public class EmployeeManagementController {
	@Autowired
	private IEmployeeManagementService empService;
	@Autowired
	private EmployeeValidator empValidator;

	@GetMapping
	public String showHomePage() {
		return "home";
	}

	@GetMapping("/show_report")
	public String showReport(
			@PageableDefault(page = 0, size = 2, sort = "id", direction = Sort.Direction.ASC) Pageable pageable,
			Map<String, Object> map) {
		Page<Employee> page = empService.showEmployeePageData(pageable);
		map.put("employeeList", page);
		return "employee_report";
	}

	@GetMapping("/add")
	public String showAddEmployeeForm(@ModelAttribute("emp") Employee emp) {
		emp.setProfile("It");
		return "employee_register";
	}

	@PostMapping("/add")
	public String addEmployee(RedirectAttributes attrs, @ModelAttribute("emp") Employee emp, BindingResult errors) {
		if (emp.getVflag().equalsIgnoreCase("no")) {
			if (errors.hasFieldErrors()) {
				return "employee_register";
			}
			if (empValidator.supports(emp.getClass())) {
				empValidator.validate(emp, errors);
				if (errors.hasErrors()) {
					return "employee_register";
				}
			}
		}

		if (emp.getProfile().equalsIgnoreCase("hacker")) {
			errors.rejectValue("profile", "profile.reject");
			return "employee_register";
		}
		String result = empService.registerEmployee(emp);
//		List<Employee>list=empService.showAllEmployees();
//		map.put("resultMsg", result);
//		map.put("employeeList", list);
		attrs.addFlashAttribute("resultMsg", result);
		return "redirect:show_report";
	}

	@GetMapping("/edit")
	public String showEditEmployeeForm(@RequestParam("no") int no, @ModelAttribute("emp") Employee emp) {
		Employee emp1 = empService.getEmployeeById(no);
		BeanUtils.copyProperties(emp1, emp);
		return "employee_edit";
	}

	@PostMapping("/edit")
	public String editEmployee(RedirectAttributes attrs, @ModelAttribute("emp") Employee emp, BindingResult errors) {
		System.out.println(emp.getVflag());
		if (emp.getVflag().equalsIgnoreCase("no")) {
			if (errors.hasFieldErrors()) {
				return "employee_edit";
			}
			if (errors.hasFieldErrors()) {
				return "employee_edit";
			}
			if (empValidator.supports(emp.getClass())) {
				empValidator.validate(emp, errors);
				if (errors.hasErrors()) {
					return "employee_edit";
				}
			}
		}
		if (emp.getProfile().equalsIgnoreCase("hacker")) {
			errors.rejectValue("profile", "profile.reject");
			return "employee_edit";
		}
		String result = empService.editEmployee(emp);
//		List<Employee>list=empService.showAllEmployees();
//		map.put("resultMsg", result);
//		map.put("employeeList", list);
		attrs.addFlashAttribute("resultMsg", result);
		return "redirect:show_report";
	}

	@GetMapping("/delete")
	public String deleteEmployee(
			@PageableDefault(page = 0, size = 2, sort = "id", direction = Sort.Direction.ASC) Pageable pageable,
			Map<String, Object> map, @RequestParam("no") int no) {
		String result = empService.deleteEmployeeById(no);
		Page<Employee> page = empService.showEmployeePageData(pageable);
		map.put("employeeList", page);
		map.put("resultMsg", result);
		return "employee_report";
	}

	@ModelAttribute("countriesInfo")
	public Set<String> populateCountries() {
		Set<String> countrySet = empService.countryNames();
		return countrySet;
	}

	@PostMapping("/stateuri")
	public String showStateByCountry(@RequestParam("country") String country, @ModelAttribute("emp") Employee emp,
			Map<String, Object> map) {
		List<String> stateNames = empService.stateNames(country);
		map.put("stateInfo",stateNames);
		return "employee_register";
	}
}
