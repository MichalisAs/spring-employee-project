package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "employee")
@Getter
@Setter
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

    public Employee() {}

    public Long getId() {
        return id == null ? null : id.longValue();
    }

    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Date getStartDate() { return startDate; }
    public void setStartDate(Date startDate) { this.startDate = startDate; }

    public Integer getVacationDays() { return vacationDays; }
    public void setVacationDays(Integer vacationDays) { this.vacationDays = vacationDays; }

    public BigDecimal getSalary() { return salary; }
    public void setSalary(BigDecimal salary) { this.salary = salary; }

    public String getEmploymentType() { return employmentType; }
    public void setEmploymentType(String employmentType) { this.employmentType = employmentType; }

    public Company getCompany() { return company; }
    public void setCompany(Company company) { this.company = company; }
}
