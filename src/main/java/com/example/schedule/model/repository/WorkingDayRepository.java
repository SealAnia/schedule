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

	@Query(value = "SELECT * FROM working_day w INNER JOIN \r\n"
			+ "employees_days e ON \r\n"
			+ "w.day_id = e.day_id\r\n"
			+ "WHERE w.date LIKE %:date% AND e.employee_id LIKE %:employeeId%", nativeQuery = true)
			//+ "WHERE w.date LIKE %2023-01% AND e.employee_id = '1'", nativeQuery = true)
	//List<WorkingDay> searchDaysForMonth(@Param("date") Date date, @Param("employee_id") Long employeeId);
	List<WorkingDay> searchDaysForMonth(@Param("date") String date, @Param("employeeId") Long employeeId);
	//List<WorkingDay> searchDaysForMonth(@Param("date") String date, @Param("employeeId") String employeeId);

}