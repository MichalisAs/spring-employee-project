package com.example.demo.dto;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BonusDTO {

    private Long id;
    private Long employeeId;
    private Long companyId;
    private BigDecimal amount;
}
