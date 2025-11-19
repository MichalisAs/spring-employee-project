package com.example.demo.mapper;

import com.example.demo.dto.EmployeeProductDTO;
import com.example.demo.entity.EmployeeProduct;
import org.springframework.stereotype.Component;

@Component
public class EmployeeProductMapper {

    // Convert Entity -> DTO
    public EmployeeProductDTO toDTO(EmployeeProduct entity) {
        if (entity == null) return null;

        EmployeeProductDTO dto = new EmployeeProductDTO();
        dto.setId(entity.getId());                         // Long -> Long
        dto.setEmployeeId(entity.getEmployee().getId());   // Long -> Long
        dto.setProductId(entity.getProduct().getId());     // Long -> Long

        return dto;
    }

    // Convert DTO -> Entity
    public EmployeeProduct toEntity(EmployeeProductDTO dto) {
        if (dto == null) return null;

        EmployeeProduct entity = new EmployeeProduct();
        entity.setId(Math.toIntExact(dto.getId()));        // Long -> Long

        // NOTE: Set the Employee and Product in the service layer, e.g.:
        // entity.setEmployee(employeeRepository.findById(dto.getEmployeeId()).orElseThrow());
        // entity.setProduct(productRepository.findById(dto.getProductId()).orElseThrow());

        return entity;
    }
}
