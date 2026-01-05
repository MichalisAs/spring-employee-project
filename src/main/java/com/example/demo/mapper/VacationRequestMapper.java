package com.example.demo.mapper;

import com.example.demo.dto.VacationRequestDTO;
import com.example.demo.entity.Employee;
import com.example.demo.entity.VacationRequest;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class VacationRequestMapper {

    private final ModelMapper modelMapper = new ModelMapper();

    // Entity -> DTO
    public VacationRequestDTO toDTO(VacationRequest entity) {
        if (entity == null) return null;

        VacationRequestDTO dto = modelMapper.map(entity, VacationRequestDTO.class);

        if (entity.getEmployee() != null) {
            dto.setEmployeeId(entity.getEmployee().getId().longValue());
        }

        return dto;
    }

    // DTO -> Entity
    public VacationRequest toEntity(VacationRequestDTO dto, Employee employee) {
        if (dto == null) return null;

        VacationRequest entity = modelMapper.map(dto, VacationRequest.class);
        entity.setEmployee(employee);

        if (dto.getStartDate() != null) {
            entity.setStartDate(Date.valueOf(dto.getStartDate()).toLocalDate());
        }

        if (dto.getEndDate() != null) {
            entity.setEndDate(Date.valueOf(dto.getEndDate()).toLocalDate());
        }

        return entity;
    }

    // Update only status
    public void updateStatus(VacationRequest entity, String status) {
        entity.setStatus(status.toUpperCase());
    }
}
