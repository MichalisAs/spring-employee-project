package com.example.demo.mapper;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Company;
import com.example.demo.entity.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    private final ModelMapper modelMapper = new ModelMapper();

    public EmployeeDTO toDTO(Employee entity) {
        return modelMapper.map(entity, EmployeeDTO.class);
    }

    public Employee toEntity(EmployeeDTO dto) {
        return modelMapper.map(dto, Employee.class);
    }

    public Employee toEntity(EmployeeMapper dto, Company company) {
        return null;
    }
}
