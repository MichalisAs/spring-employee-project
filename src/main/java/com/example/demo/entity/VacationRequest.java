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

@Entity
@Table(name = "vacation_request")
@Getter
@Setter
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

    public VacationRequest() {}

    public Long getId() {
        return 0L;
    }
}
