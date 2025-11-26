package com.example.demo.service;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // <--- added import
import java.util.ArrayList;
import java.util.List;

@Service
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
    @Transactional // Needed when creating a new Employee in DB
    public EmployeeDTO create(EmployeeDTO dto) {
        return null;
    }

    @Override
    @Transactional // Needed when updating an Employee
    public EmployeeDTO update(Long id, EmployeeDTO dto) {
        return null;
    }

    @Override
    @Transactional // Needed when deleting an Employee
    public void delete(Long id) {

    }

    @Override
    public EmployeeDTO getById(Long id) {
        return null; // read-only
    }

    @Override
    public List<EmployeeDTO> getAll() {
        return List.of(); // read-only
    }
}
