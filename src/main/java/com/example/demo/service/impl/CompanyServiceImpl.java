package com.example.demo.service.impl;

import com.example.demo.dto.CompanyDTO;
import com.example.demo.entity.Company;
import com.example.demo.entity.Employee;
import com.example.demo.mapper.CompanyMapper;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final EmployeeRepository employeeRepository;
    private final CompanyMapper mapper;

    public CompanyServiceImpl(CompanyRepository companyRepository, EmployeeRepository employeeRepository, CompanyMapper mapper) {
        this.companyRepository = companyRepository;
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;
    }

    @Override
    public CompanyDTO create(CompanyDTO dto) {
        Company entity = mapper.toEntity(dto);
        return mapper.toDTO(companyRepository.save(entity));
    }

    @Override
    public CompanyDTO update(Long id, CompanyDTO dto) {
        Company entity = companyRepository.findById(id).orElseThrow();
        mapper.updateEntity(entity, dto);
        return mapper.toDTO(companyRepository.save(entity));
    }

    @Override
    public void delete(Long id) {
        companyRepository.deleteById((long) id.intValue());
    }

    @Override
    public CompanyDTO getById(Long id) {
        Company entity = companyRepository.findById((long) id.intValue()).orElseThrow();
        return mapper.toDTO(entity);
    }

    @Override
    public List<CompanyDTO> getAll() {
        return companyRepository.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public Double calculateMonthlyExpenses(Long companyId) {
        Company company = companyRepository.findById((long) companyId.intValue()).orElseThrow();
        List<Employee> employees = employeeRepository.findByCompany(company);
        return employees.stream().mapToDouble(e -> e.getSalary().doubleValue()).sum();
    }
}
