package com.example.demo.entity;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "vacation_request")
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
        return (id == null) ? null : id.longValue();
    }
    public void setId(Integer id) { this.id = id; }

    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }

    public Date getStartDate() { return startDate; }
    public void setStartDate(Date startDate) { this.startDate = startDate; }

    public Date getEndDate() { return endDate; }
    public void setEndDate(Date endDate) { this.endDate = endDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Integer getDays() { return days; }
    public void setDays(Integer days) { this.days = days; }
}
