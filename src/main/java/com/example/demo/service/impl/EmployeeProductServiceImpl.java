package com.example.demo.service;

import com.example.demo.dto.EmployeeProductDTO;
import com.example.demo.dto.ProductDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // <--- added import

import java.util.List;
import java.util.Map;

@Service
public class EmployeeProductServiceImpl implements EmployeeProductService {

    @Override
    @Transactional // Needed when creating a new EmployeeProduct in DB
    public EmployeeProductDTO create(EmployeeProductDTO dto) {
        return null;
    }

    @Override
    @Transactional // Needed when updating an existing EmployeeProduct
    public EmployeeProductDTO update(Long id, EmployeeProductDTO dto) {
        return null;
    }

    @Override
    @Transactional // Needed when deleting an EmployeeProduct
    public void delete(Long id) {
    }

    @Override
    public EmployeeProductDTO getById(Long id) {
        return null; // read-only, no transaction needed
    }

    @Override
    public List<EmployeeProductDTO> getAll() {
        return null; // read-only
    }

    @Override
    public Map<String, List<ProductDTO>> getProductsByCompany(Long companyId) {
        return null; // read-only
    }
}
