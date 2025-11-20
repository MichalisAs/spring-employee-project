package com.example.demo.service;

import com.example.demo.dto.EmployeeProductDTO;
import com.example.demo.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EmployeeProductServiceImpl implements EmployeeProductService {

    @Override
    public EmployeeProductDTO create(EmployeeProductDTO dto) {
        return null;
    }

    @Override
    public EmployeeProductDTO update(Long id, EmployeeProductDTO dto) {
        return null;
    }

    @Override
    public void delete(Long id) {
    }

    @Override
    public EmployeeProductDTO getById(Long id) {
        return null;
    }

    @Override
    public List<EmployeeProductDTO> getAll() {
        return null;
    }

    @Override
    public Map<String, List<ProductDTO>> getProductsByCompany(Long companyId) {
        return null;
    }
}
