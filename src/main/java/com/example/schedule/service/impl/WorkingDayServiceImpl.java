package com.example.schedule.service.impl;

import com.example.schedule.model.entity.WorkingDay;
import com.example.schedule.model.repository.WorkingDayRepository;
import com.example.schedule.service.WorkingDayService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkingDayServiceImpl implements WorkingDayService {

    private WorkingDayRepository workingDayRepository;

    @Autowired
    public WorkingDayServiceImpl(WorkingDayRepository workingDayRepository) {
        this.workingDayRepository = workingDayRepository;
    }

    @Override
    public List<WorkingDay> getAll() {
        return workingDayRepository.findAll();
    }

    @Override
    public WorkingDay getById(Long dayId) {
        return workingDayRepository.findById(dayId).get();
    }

    @Override
    public WorkingDay addNewOrUpdate(WorkingDay workingDay) {
        workingDay.setDate(workingDay.getDate());
        return workingDayRepository.saveAndFlush(workingDay);
    }
    
    @Override
    public void delete(Long dayId) {
        workingDayRepository.deleteById(dayId);
    }
    
    @Override
	public List<WorkingDay> searchDaysForMonth(String date, Long employeeId) {
		return workingDayRepository.searchDaysForMonth(date, employeeId);
	}
	
    @Override
    public List<WorkingDay> findAllEmployeesBetweenDates(String dateTo, String dateFrom, Long employeeId) {
    	return workingDayRepository.findAllEmployeesBetweenDates(dateTo, dateFrom, employeeId);
    }

    @Override
    public List<WorkingDay> findFutureDays() {
        return workingDayRepository.findFutureDays();
    }
    
}
