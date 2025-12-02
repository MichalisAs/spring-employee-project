package com.example.demo.mapper;

import com.example.demo.dto.EmployeeProductDTO;
import com.example.demo.entity.EmployeeProduct;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EmployeeProductMapper {

    private final ModelMapper modelMapper = new ModelMapper();

    public EmployeeProductDTO toDTO(EmployeeProduct entity) {
        EmployeeProductDTO dto = modelMapper.map(entity, EmployeeProductDTO.class);

        if (entity.getEmployee() != null) {
            dto.setEmployeeId(entity.getEmployee().getId().longValue());
        }

        if (entity.getProduct() != null) {
            dto.setProductId(entity.getProduct().getId());
        }

        return dto;
    }

    public EmployeeProduct toEntity(EmployeeProductDTO dto) {
        EmployeeProduct entity = modelMapper.map(dto, EmployeeProduct.class);

        if (dto.getId() != null) {
            entity.setId(dto.getId().intValue());
        }

        // Employee and Product are set inside the service layer
        return entity;
    }
}
