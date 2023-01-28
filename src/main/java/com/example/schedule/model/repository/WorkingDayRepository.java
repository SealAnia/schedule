package com.example.schedule.model.repository;

import com.example.schedule.model.entity.WorkingDay;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkingDayRepository extends JpaRepository<WorkingDay, Long> {

	@Query(value = "SELECT w.day_id, w.date, e.employee_id FROM working_day w INNER JOIN \r\n"
			+ "employees_days e ON \r\n"
			+ "w.day_id = e.day_id\r\n"
			+ "WHERE w.date LIKE %:date% AND e.employee_id LIKE %:employeeId%", nativeQuery = true)
	//@Query(value = "SELECT date, employee_id FROM schedule.working_day INNER JOIN \n" +
			//"schedule.employees_days ON \n" +
			//"schedule.working_day.day_id = schedule.employees_days.day_id\n" +
			//"WHERE date LIKE '%2023-01%' AND employee_id = '1';", nativeQuery = true)
	List<WorkingDay> searchDaysForMonth(@Param("date") String date, @Param("employeeId") Long employeeId);

}