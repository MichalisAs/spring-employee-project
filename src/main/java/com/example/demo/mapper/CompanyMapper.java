package com.example.demo.mapper;

import com.example.demo.dto.CompanyDTO;
import com.example.demo.entity.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper {

    public CompanyDTO toDTO(Company entity) {
        if (entity == null) return null;

        CompanyDTO dto = new CompanyDTO();
        dto.setId(entity.getId().longValue());
        dto.setName(entity.getName());
        dto.setAddress(entity.getAddress());
        dto.setPhone(entity.getPhone());
        return dto;
    }

    public Company toEntity(CompanyDTO dto) {
        if (dto == null) return null;

        Company entity = new Company();
        entity.setId(dto.getId() == null ? null : Math.toIntExact(dto.getId())); // Long → Integer conversion
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        entity.setPhone(dto.getPhone());
        return entity;
    }

    public void updateEntity(Company entity, CompanyDTO dto) {
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        entity.setPhone(dto.getPhone());
    }
}
