package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "employee")
@Getter
@Setter
@NoArgsConstructor
public class Employee {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "surname", nullable = false, length = 50)
    private String surname;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "vacation_days", nullable = false)
    private Integer vacationDays;

    @Column(name = "salary", nullable = false)
    private BigDecimal salary;

    @Column(name = "employment_type", nullable = false, length = 50)
    private String employmentType;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    public Long getId() {
        return 0L;
    }

    public String getName() {
        return "";
    }

    public Integer getVacationDays() {
        return 0;
    }

    public CallableStatement getStartDate() {
        return null;
    }

    public Company getCompany() {
        return null;
    }

    public LocalDate valueOf(Object startDate) {
        return null;
    }
}
