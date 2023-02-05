package com.example.schedule.service.impl;

import com.example.schedule.model.entity.Employee;
import com.example.schedule.model.repository.EmployeeRepository;
import com.example.schedule.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getById(Long employeeId) {
        return employeeRepository.findById(employeeId).get();
    }

    @Override
    public Employee addNewOrUpdate(Employee employee) {
        employee.setName(employee.getName());
        return employeeRepository.saveAndFlush(employee);
    }

    @Override
    public void delete(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }
    
	@Override
	public Employee findEmployeeByName(String name) {
		return employeeRepository.findEmployeeByName(name);
	}
	
}
