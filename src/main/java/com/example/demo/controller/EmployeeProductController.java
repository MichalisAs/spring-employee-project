package com.example.demo.controller;

import com.example.demo.dto.EmployeeProductDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.service.EmployeeProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee-products")
public class EmployeeProductController {

    private final EmployeeProductService service;

    public EmployeeProductController(EmployeeProductService service) {
        this.service = service;
    }

    @PostMapping
    public EmployeeProductDTO create(@RequestBody EmployeeProductDTO dto) {
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public EmployeeProductDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<EmployeeProductDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/by-company/{companyId}")
    public Map<String, List<ProductDTO>> getProductsByCompany(@PathVariable Long companyId) {
        return service.getProductsByCompany(companyId);
    }
}
