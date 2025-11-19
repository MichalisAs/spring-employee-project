package com.example.demo.service;

import com.example.demo.dto.EmployeeProductDTO;
import java.util.List;

public interface EmployeeProductService {

    EmployeeProductDTO create(EmployeeProductDTO dto);

    EmployeeProductDTO update(Long id, EmployeeProductDTO dto);

    void delete(Long id);

    EmployeeProductDTO getById(Long id);

    List<EmployeeProductDTO> getAll();
}
