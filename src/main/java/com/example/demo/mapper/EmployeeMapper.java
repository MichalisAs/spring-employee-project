package com.example.demo.mapper;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public EmployeeDTO toDTO(Employee employee) {
        if (employee == null) return null;

        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(employee.getId());
        dto.setName(employee.getName());
        dto.setSurname(employee.getSurname());
        dto.setEmail(employee.getEmail());
        dto.setStartDate(employee.getStartDate());
        dto.setVacationDays(employee.getVacationDays());
        dto.setSalary(employee.getSalary());
        dto.setEmploymentType(employee.getEmploymentType());
        dto.setCompanyId(employee.getCompanyId());
        return dto;
    }

    public Employee toEntity(EmployeeDTO dto) {
        if (dto == null) return null;

        Employee employee = new Employee();
        employee.setId(dto.getId());
        employee.setName(dto.getName());
        employee.setSurname(dto.getSurname());
        employee.setEmail(dto.getEmail());
        employee.setStartDate(dto.getStartDate());
        employee.setVacationDays(dto.getVacationDays());
        employee.setSalary(dto.getSalary());
        employee.setEmploymentType(dto.getEmploymentType());
        employee.setCompanyId(dto.getCompanyId());
        return employee;
    }
}
