package com.ankit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ankit.model.Employee;

public interface IEmployeeManagementRepo extends JpaRepository<Employee, Integer> {

}
