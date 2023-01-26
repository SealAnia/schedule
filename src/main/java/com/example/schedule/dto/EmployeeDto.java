package com.example.schedule.dto;

import java.util.List;

import com.example.schedule.model.entity.WorkingDay;

public class EmployeeDto {
	
	private Long employeeId;
	private String name;
	private List<WorkingDay> workingDays;
	
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<WorkingDay> getWorkingDays() {
		return workingDays;
	}
	public void setWorkingDays(List<WorkingDay> workingDays) {
		this.workingDays = workingDays;
	}

}
