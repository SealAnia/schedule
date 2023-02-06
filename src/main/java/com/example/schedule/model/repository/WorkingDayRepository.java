package com.example.schedule.model.repository;

import com.example.schedule.model.entity.WorkingDay;

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
	List<WorkingDay> searchDaysForMonth(@Param("date") String date, @Param("employeeId") Long employeeId);
	
	@Query(value = "SELECT * FROM working_day w INNER JOIN employees_days ed ON w.day_id = ed.day_id\n" +
	        "WHERE w.date BETWEEN :dateFrom AND :dateTo AND ed.employee_id = :employeeId", nativeQuery = true)
	List<WorkingDay> findAllEmployeesBetweenDates(@Param("dateTo")String dateTo, @Param("dateFrom")String dateFrom,
			@Param("employeeId") Long employeeId);

	//@Query(value = "SELECT * FROM working_day w WHERE w.date >= CURDATE()", nativeQuery = true)
	@Query(value = "SELECT w.day_id, w.date, e.name FROM working_day w " +
			"LEFT JOIN employees_days ed ON w.day_id = ed.day_id " +
			"LEFT JOIN employee e ON ed.employee_id = e.employee_id WHERE w.date >= CURDATE()", nativeQuery = true)
	List<WorkingDay> findFutureDays();
	
}