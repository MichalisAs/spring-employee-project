package com.example.demo.mapper;

import com.example.demo.dto.VacationRequestDTO;
import com.example.demo.entity.Employee;
import com.example.demo.entity.VacationRequest;
import org.springframework.stereotype.Component;

@Component
public class VacationRequestMapper {

    public VacationRequestDTO toDTO(VacationRequest entity) {
        if (entity == null) return null;

        VacationRequestDTO dto = new VacationRequestDTO();
        dto.setId(entity.getId().longValue());
        dto.setEmployeeId(entity.getEmployee().getId().longValue());
        dto.setStartDate(entity.getStartDate().toLocalDate());
        dto.setEndDate(entity.getEndDate().toLocalDate());
        dto.setStatus(entity.getStatus());
        dto.setDays(entity.getDays());
        return dto;
    }

    public VacationRequest toEntity(VacationRequestDTO dto, Employee employee) {
        if (dto == null) return null;

        VacationRequest entity = new VacationRequest();
        entity.setEmployee(employee);
        entity.setStartDate(dto.getStartDate() == null ? null : java.sql.Date.valueOf(dto.getStartDate()));
        entity.setEndDate(dto.getEndDate() == null ? null : java.sql.Date.valueOf(dto.getEndDate()));
        entity.setDays(dto.getDays());
        entity.setStatus(dto.getStatus()); // fix: set from DTO
        return entity;
    }

    public void updateStatus(VacationRequest entity, String status) {
        entity.setStatus(
                String.valueOf(Enum.valueOf(com.example.demo.enums.VacationStatus.class, status.toUpperCase()))
        );
    }
}
