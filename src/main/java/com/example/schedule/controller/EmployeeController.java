package com.example.schedule.controller;

import com.example.schedule.model.entity.Employee;
import com.example.schedule.model.entity.WorkingDay;
import com.example.schedule.service.WorkingDayService;
import com.example.schedule.service.impl.EmployeeServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    private EmployeeServiceImpl employeeService;
    private WorkingDayService workingDayService;

    @Autowired
    public EmployeeController(EmployeeServiceImpl employeeService, WorkingDayService workingDayService) {
        this.employeeService = employeeService;
        this.workingDayService = workingDayService;
    }

    @GetMapping(value = "")
    public List<Employee> findAllEmployees() {
        return employeeService.getAll();
    }

    @GetMapping(value = "/{employeeId}")
    public Employee findEmployeeById(@PathVariable Long employeeId) {
        return employeeService.getById(employeeId);
    }

    @PostMapping(value = "/")
    public void addNewEmployee(@RequestBody Employee employee) {
        employeeService.addNewOrUpdate(employee);
    }

    @PutMapping(value = "/{employeeId}")
    public ResponseEntity<Employee> editEmployeeInfo(@PathVariable Long employeeId, @RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.getById(employeeId);
        updatedEmployee.setName(employee.getName());
        employeeService.addNewOrUpdate(updatedEmployee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping(value = "/{employeeId}")
    public void deleteEmployee(@PathVariable Long employeeId) {
        employeeService.delete(employeeId);
    }
    
    @GetMapping(value = "/edit/{employeeId}")
	public ModelAndView showDaysAndHoursForm(@PathVariable Long employeeId, @ModelAttribute(name = "newEmployee") Employee newEmployee) {
		Employee employee = employeeService.getById(employeeId);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("set_hours");
		modelAndView.addObject("employee", employee);
		return modelAndView;
	}
    
    @PostMapping(value = "/by_id/{employeeId}")
	public ModelAndView updateHours(@ModelAttribute(name = "employee") Employee emp, @RequestParam(name = "dayId") Long dayId) {
		ModelAndView modelAndView = new ModelAndView();
		Employee employee = employeeService.getById(emp.getEmployeeId());
		
		WorkingDay day = workingDayService.getById(dayId);
        employee.addWorkingDay(day);

		employeeService.addNewOrUpdate(employee);
		modelAndView.setViewName("employee_info");
		modelAndView.addObject("employee", employee);
		modelAndView.addObject("days", workingDayService.getAll());
		return modelAndView;
	}

    @GetMapping(value = "/searchform")
    public ModelAndView showSearchForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("search_form");
        return modelAndView;
    }
    
    @GetMapping(value = "/employees/days_in_month")
    public ModelAndView getDaysForEmployee(@RequestParam(value = "date", required = false) String date,
                                           @RequestParam(value = "employeeId", required = false) Long employeeId) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("days_employees");

        var daysForEmployee = employeeService.countDays(date, employeeId);
        modelAndView.addObject("days_employees", daysForEmployee);

        Employee employee = employeeService.getById(employeeId);
        modelAndView.addObject("employee", employee);

        var totalDays = daysForEmployee.size();
        modelAndView.addObject("totalDays", totalDays);

        return modelAndView;
    }
    
}
