package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class EmployeeDTO {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private LocalDate startDate;
    private Integer vacationDays;
    private BigDecimal salary;
    private String employmentType;
    private Long companyId;

    public Object getStartDate() {
        return null;
    }

    public Object getVacationDays() {
        return null;
    }
}
