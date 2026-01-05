package com.example.demo.service.impl;

import com.example.demo.dto.EmployeeProductDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Employee;
import com.example.demo.entity.EmployeeProduct;
import com.example.demo.entity.Product;
import com.example.demo.repository.EmployeeProductRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.EmployeeProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeProductServiceImpl implements EmployeeProductService {

    private final EmployeeProductRepository repository;
    private final EmployeeRepository employeeRepository;
    private final ProductRepository productRepository;

    public EmployeeProductServiceImpl(EmployeeProductRepository repository,
                                      EmployeeRepository employeeRepository,
                                      ProductRepository productRepository) {
        this.repository = repository;
        this.employeeRepository = employeeRepository;
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public EmployeeProductDTO create(EmployeeProductDTO dto) {
        EmployeeProduct ep = new EmployeeProduct();
        ep.setEmployee(employeeRepository.findById(dto.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found")));
        ep.setProduct(productRepository.findById(dto.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found")));
        ep.setQuantity(1); // default quantity
        EmployeeProduct saved = repository.save(ep);

        EmployeeProductDTO result = new EmployeeProductDTO();
        result.setId(Long.valueOf(saved.getId()));
        result.setEmployeeId(saved.getEmployee().getId());
        result.setProductId(saved.getProduct().getId());
        return result;
    }

    @Override
    @Transactional
    public EmployeeProductDTO update(Long id, EmployeeProductDTO dto) {
        EmployeeProduct ep = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("EmployeeProduct not found"));
        ep.setEmployee(employeeRepository.findById(dto.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found")));
        ep.setProduct(productRepository.findById(dto.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found")));
        EmployeeProduct saved = repository.save(ep);

        EmployeeProductDTO result = new EmployeeProductDTO();
        result.setId(Long.valueOf(saved.getId()));
        result.setEmployeeId(saved.getEmployee().getId());
        result.setProductId(saved.getProduct().getId());
        return result;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public EmployeeProductDTO getById(Long id) {
        EmployeeProduct ep = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("EmployeeProduct not found"));
        EmployeeProductDTO dto = new EmployeeProductDTO();
        dto.setId(Long.valueOf(ep.getId()));
        dto.setEmployeeId(ep.getEmployee().getId());
        dto.setProductId(ep.getProduct().getId());
        return dto;
    }

    @Override
    public List<EmployeeProductDTO> getAll() {
        return repository.findAll().stream().map(ep -> {
            EmployeeProductDTO dto = new EmployeeProductDTO();
            dto.setId(Long.valueOf(ep.getId()));
            dto.setEmployeeId(ep.getEmployee().getId());
            dto.setProductId(ep.getProduct().getId());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public Map<String, List<ProductDTO>> getProductsByCompany(Long companyId) {
        List<Employee> employees = employeeRepository.findByCompanyId(companyId);
        Map<String, List<ProductDTO>> result = new HashMap<>();

        for (Employee emp : employees) {
            List<EmployeeProduct> eps = repository.findAll().stream()
                    .filter(ep -> ep.getEmployee().getId().equals(emp.getId()))
                    .collect(Collectors.toList());

            if (!eps.isEmpty()) {
                List<ProductDTO> products = eps.stream().map(ep -> {
                    Product p = ep.getProduct();
                    ProductDTO dto = new ProductDTO();
                    dto.setId(p.getId());
                    dto.setName(p.getName());
                    dto.setDescription(p.getDescription());
                    dto.setBarcode(p.getBarcode());
                    return dto;
                }).toList();

                result.put(emp.getName() + " " + emp.getSurname(), products);
            }
        }

        return result;
    }
}
