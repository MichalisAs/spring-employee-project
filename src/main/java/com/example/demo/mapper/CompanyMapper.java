package com.example.demo.mapper;

import com.example.demo.dto.CompanyDTO;
import com.example.demo.entity.Company;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper {

    private final ModelMapper modelMapper = new ModelMapper();

    public CompanyDTO toDTO(Company entity) {
        return modelMapper.map(entity, CompanyDTO.class);
    }

    public Company toEntity(CompanyDTO dto) {
        Company entity = modelMapper.map(dto, Company.class);

        // Manual fix: Long DTO ID → Integer entity ID
       // if (dto.getId() != null) {
         //   entity.setId(dto.getId().intValue());
        //}

        return entity;
    }

    public void updateEntity(Company entity, CompanyDTO dto) {
        modelMapper.map(dto, entity);
    }
}
