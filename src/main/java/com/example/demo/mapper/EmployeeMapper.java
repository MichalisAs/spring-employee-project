package com.example.demo.mapper;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Company;
import com.example.demo.entity.Employee;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class EmployeeMapper {

    public EmployeeDTO toDTO(Employee entity) {
        if (entity == null) return null;

        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setEmail(entity.getEmail());
        dto.setStartDate(entity.getStartDate().toLocalDate());
        dto.setVacationDays(entity.getVacationDays());
        dto.setSalary(entity.getSalary());
        dto.setEmploymentType(entity.getEmploymentType());
        dto.setCompanyId(entity.getCompany() != null ? entity.getCompany().getId() : null);
        return dto;
    }

    public Employee toEntity(EmployeeDTO dto, Company company) {
        if (dto == null) return null;

        Employee entity = new Employee();
        entity.setId(Math.toIntExact(dto.getId()));
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setEmail(dto.getEmail());
        entity.setStartDate((Date) dto.getStartDate());
        entity.setVacationDays(dto.getVacationDays());
        entity.setSalary(dto.getSalary());
        entity.setEmploymentType(dto.getEmploymentType());
        entity.setCompany(company);
        return entity;
    }

    public void updateEntity(Employee entity, EmployeeDTO dto, Company company) {
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setEmail(dto.getEmail());
        entity.setStartDate((Date) dto.getStartDate());
        entity.setVacationDays(dto.getVacationDays());
        entity.setSalary(dto.getSalary());
        entity.setEmploymentType(dto.getEmploymentType());
        entity.setCompany(company);
    }
}
