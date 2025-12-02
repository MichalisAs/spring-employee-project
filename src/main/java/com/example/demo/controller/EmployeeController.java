package com.example.demo.controller;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    public EmployeeMapper create(@RequestBody EmployeeMapper dto) {
        return (EmployeeMapper) service.create(dto);
    }

    @PutMapping("/{id}")
    public EmployeeMapper update(@PathVariable Long id, @RequestBody EmployeeMapper dto) {
        return service.update (id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    public EmployeeMapper getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<EmployeeDTO> getAll() {
        return service.getAll();
    }
}
