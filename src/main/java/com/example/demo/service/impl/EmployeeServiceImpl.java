package com.example.demo.service;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Employee;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

// Σημαντικό: @Service για να γίνει bean του Spring
@Service
public class EmployeeServiceImpl implements EmployeeService {

    // Απλή λίστα για παράδειγμα
    private final List<Employee> employees = new ArrayList<>();

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    @Override
    public EmployeeDTO create(EmployeeDTO dto) {
        return null;
    }

    @Override
    public EmployeeDTO update(Long id, EmployeeDTO dto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public EmployeeDTO getById(Long id) {
        return null;
    }

    @Override
    public List<EmployeeDTO> getAll() {
        return List.of();
    }
}
