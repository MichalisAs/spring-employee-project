package com.example.demo.controller;

import com.example.demo.dto.CompanyDTO;
import com.example.demo.service.CompanyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService service;

    public CompanyController(CompanyService service) {
        this.service = service;
    }

    @PostMapping
    public CompanyDTO create(@RequestBody CompanyDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public CompanyDTO update(@PathVariable Long id, @RequestBody CompanyDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    public CompanyDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<CompanyDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}/monthly-expenses")
    public Double getMonthlyExpenses(@PathVariable Long id) {
        return service.calculateMonthlyExpenses(id);
    }
}
