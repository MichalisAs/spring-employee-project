package com.example.demo.service;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    void addEmployee(Employee employee);

    EmployeeMapper create(EmployeeMapper dto);

//    EmployeeMapper update(Long id, EmployeeMapper dto);

    @Transactional // Needed when creating a new Employee in DB
    EmployeeDTO create(EmployeeDTO dto);

    @Transactional // Needed when updating an Employee
    EmployeeDTO update(Long id, EmployeeDTO dto);

    @Transactional
  //  Object create(EmployeeMapper dto);

    void delete(Long id);

//    EmployeeMapper getById(Long id);

    List<EmployeeDTO> getAll();

    EmployeeMapper getById(Long id);

    EmployeeMapper update(Long id, EmployeeMapper dto);
}
