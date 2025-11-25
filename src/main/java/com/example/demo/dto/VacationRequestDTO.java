package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class VacationRequestDTO {

    private Long id;
    private Long employeeId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
    private Integer days;
}
