package com.example.schedule.service;

import java.util.List;

import com.example.schedule.model.entity.WorkingDay;

public interface WorkingDayService extends DefaultService<WorkingDay> {
	
	List<WorkingDay> searchDaysForMonth(String date, Long employeeId);
	List<WorkingDay> findAllEmployeesBetweenDates(String dateTo, String dateFrom, Long employeeId);
	
}
