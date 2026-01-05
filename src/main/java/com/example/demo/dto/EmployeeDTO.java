package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeDTO {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private LocalDate startDate;
    private Integer vacationDays;
    private Double salary;
    private String employmentType;
    private Long companyId;
}
