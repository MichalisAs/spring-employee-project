package com.example.demo.service;

import com.example.demo.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    EmployeeDTO create(EmployeeDTO dto);

    EmployeeDTO update(Long id, EmployeeDTO dto);

    void delete(Long id);

    EmployeeDTO getById(Long id);

    List<EmployeeDTO> getAll();
}
