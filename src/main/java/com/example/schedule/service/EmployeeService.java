package com.example.schedule.service;

import com.example.schedule.model.entity.Employee;

public interface EmployeeService extends DefaultService<Employee> {
	
	Employee findEmployeeByName(String name);
	
}
