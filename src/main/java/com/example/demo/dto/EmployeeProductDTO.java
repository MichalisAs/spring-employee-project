package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeProductDTO {

    private Long id;
    private Long employeeId;
    private Long productId;

    public Number getId() {
        return null;
    }

    public void setProductId(Number id) {
    }

    public void setEmployeeId(long l) {
    }
}
