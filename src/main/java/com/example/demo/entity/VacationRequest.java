package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vacation_request")
@Getter
@Setter
@NoArgsConstructor
public class VacationRequest {

    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    private String status;

    private Integer days;

    public void getClass(String name) {
    }

    public void setEndDate(Date date) {
    }

    public void setStatus(String upperCase) {
    }

    public void setStartDate(Date date) {
    }

    public Integer getDays() {
        return 0;
    }

    public Employee getEmployee() {
        return null;
    }

    public void setEmployee(Employee employee) {
    }

    public void setDays(int daysRequested) {
    }
}
