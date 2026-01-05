package com.example.demo.service;

import com.example.demo.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDTO> getAll();
    EmployeeDTO getById(Long id);
    EmployeeDTO create(EmployeeDTO dto);
    EmployeeDTO update(Long id, EmployeeDTO dto);
    void delete(Long id);

    // Προαιρετικά: employees με συγκεκριμένο companyId
    List<EmployeeDTO> getByCompanyId(Long companyId);
}
