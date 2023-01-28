package com.example.schedule.controller;

import com.example.schedule.model.entity.Employee;
import com.example.schedule.model.entity.WorkingDay;
import com.example.schedule.model.repository.EmployeeRepository;
import com.example.schedule.service.impl.WorkingDayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/days")
public class WorkingDayController {

    private final WorkingDayServiceImpl workingDayService;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public WorkingDayController(WorkingDayServiceImpl workingDayService, EmployeeRepository employeeRepository) {
        this.workingDayService = workingDayService;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping(value = "")
    public List<WorkingDay> findAllDays() {
        return workingDayService.getAll();
    }

    @GetMapping(value = "/{dayId}")
    public WorkingDay findWorkingDayById(@PathVariable Long dayId) {
        return workingDayService.getById(dayId);
    }

    @GetMapping(value = "/{day_id}/employees")
    public List<Employee> employeesForDay(@PathVariable Long day_id) {
        WorkingDay day = workingDayService.getById(day_id);
        List<Employee> employeesForDay = day.getEmployees();
        return employeesForDay;
    }

    @PostMapping(value = "/")
    public void addNewWorkingDay(@RequestBody WorkingDay workingDay) {
        workingDayService.addNewOrUpdate(workingDay);
    }

    @PostMapping(value = "/employees/{employeeId}/days")
    public ResponseEntity<WorkingDay> addDay(@PathVariable(value = "employeeId") Long employeeId,
                                             @RequestBody WorkingDay dayReq) {
        Optional<Object> day = employeeRepository.findById(employeeId).map(employee -> {
            long dayId = dayReq.getDayId();
            if(dayId != 0L) {
                WorkingDay newDay = workingDayService.getById(dayId);
                employee.addWorkingDay(newDay);
                employeeRepository.save(employee);
                return newDay;
            }
            employee.addWorkingDay(dayReq);
            return workingDayService.addNewOrUpdate(dayReq);
        });
        return new ResponseEntity(day, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{dayId}")
    public ResponseEntity<WorkingDay> editDayInfo(@PathVariable Long dayId, @RequestBody WorkingDay workingDay) {
        WorkingDay updatedWorkingDay = workingDayService.getById(dayId);
        updatedWorkingDay.setDate(workingDay.getDate());
        workingDayService.addNewOrUpdate(updatedWorkingDay);
        return ResponseEntity.ok(updatedWorkingDay);
    }

    @DeleteMapping(value = "/{dayId}")
    public void deleteWorkingDay(@PathVariable Long dayId) {
        workingDayService.delete(dayId);
    }

}
