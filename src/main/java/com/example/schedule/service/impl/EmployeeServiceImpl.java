package com.example.schedule.service.impl;

import com.example.schedule.model.entity.Employee;
import com.example.schedule.model.entity.WorkingDay;
import com.example.schedule.model.repository.EmployeeRepository;
import com.example.schedule.model.repository.WorkingDayRepository;
import com.example.schedule.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private WorkingDayRepository workingDayRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, WorkingDayRepository workingDayRepository) {
        this.employeeRepository = employeeRepository;
        this.workingDayRepository = workingDayRepository;
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

	public List<WorkingDay> countDays(String date, Long employeeId) {
		return workingDayRepository.searchDaysForMonth(date, employeeId);
	}
}
