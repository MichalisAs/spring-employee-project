package com.example.demo.service.impl;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Employee;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // <--- added import
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    // In-memory list for example purposes
    private final List<Employee> employees = new ArrayList<>();

    @Override
    public List<Employee> getAllEmployees() {
        return employees; // read-only, no transaction needed
    }

    @Override
    @Transactional // Needed if adding to DB
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    @Override
    public EmployeeMapper create(EmployeeMapper dto) {
        return null;
    }

    @Transactional
    @Override
    public EmployeeDTO create(EmployeeDTO dto) {
        return null;
    }

    @Transactional
    @Override
    public EmployeeDTO update(Long id, EmployeeDTO dto) {
        return null;
    }

    @Override
    @Transactional // Needed when deleting an Employee
    public void delete(Long id) {

    }

    @Override
    public EmployeeMapper getById(Long id) {
        return null; // read-only
    }

    @Override
    public EmployeeMapper update(Long id, EmployeeMapper dto) {
        return null;
    }

    @Override
    public List<EmployeeDTO> getAll() {
        return List.of(); // read-only
    }
}