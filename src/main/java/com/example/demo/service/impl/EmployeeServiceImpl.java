package com.example.demo.service.impl;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Employee;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;
    private final EmployeeMapper mapper;

    public EmployeeServiceImpl(EmployeeRepository repository, EmployeeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<EmployeeDTO> getAll() {
        return repository.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO getById(Long id) {
        return mapper.toDTO(repository.findById(id).orElseThrow());
    }

    @Override
    public EmployeeDTO create(EmployeeDTO dto) {
        Employee employee = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(employee));
    }

    @Override
    public EmployeeDTO update(Long id, EmployeeDTO dto) {
        Employee employee = repository.findById(id).orElseThrow();
        employee.setName(dto.getName());
        employee.setSurname(dto.getSurname());
        employee.setEmail(dto.getEmail());
        employee.setStartDate(dto.getStartDate());
        employee.setVacationDays(dto.getVacationDays());
        employee.setSalary(dto.getSalary());
        employee.setEmploymentType(dto.getEmploymentType());
        employee.setCompanyId(dto.getCompanyId());
        return mapper.toDTO(repository.save(employee));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<EmployeeDTO> getByCompanyId(Long companyId) {
        return repository.findByCompanyId(companyId).stream().map(mapper::toDTO).collect(Collectors.toList());
    }
}
