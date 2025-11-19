
package com.example.demo.service;

import com.example.demo.dto.EmployeeProductDTO;
import com.example.demo.dto.ProductDTO;

import java.util.List;
import java.util.Map;

public interface EmployeeProductService {

    EmployeeProductDTO create(EmployeeProductDTO dto);

    EmployeeProductDTO update(Long id, EmployeeProductDTO dto);

    void delete(Long id);

    EmployeeProductDTO getById(Long id);

    List<EmployeeProductDTO> getAll();

    Map<String, List<ProductDTO>> getProductsByCompany(Long companyId);
}
