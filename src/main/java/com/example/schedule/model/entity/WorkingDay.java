package com.example.schedule.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
//import lombok.Getter;
//import lombok.Setter;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "working_day")
//@Getter
//@Setter
public class WorkingDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "day_id", nullable = false)
    private Long dayId;
    @Column(name = "date", nullable = false)
    private Date date;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},mappedBy = "workingDays")
    //@JsonIgnore
    private List<Employee> employees;

    public WorkingDay() {
    }

	public Long getDayId() {
		return dayId;
	}

	public void setDayId(Long dayId) {
		this.dayId = dayId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}