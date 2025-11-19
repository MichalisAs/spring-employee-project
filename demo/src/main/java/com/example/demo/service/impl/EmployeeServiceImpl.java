package com.example.demo.service.impl;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Company;
import com.example.demo.entity.Employee;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;
    private final CompanyRepository companyRepository;
    private final EmployeeMapper mapper;

    public EmployeeServiceImpl(EmployeeRepository repository, CompanyRepository companyRepository, EmployeeMapper mapper) {
        this.repository = repository;
        this.companyRepository = companyRepository;
        this.mapper = mapper;
    }

    @Override
    public EmployeeDTO create(EmployeeDTO dto) {
        Company company = companyRepository.findById((long) dto.getCompanyId().intValue()).orElseThrow();
        Employee entity = mapper.toEntity(dto, company);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public EmployeeDTO update(Long id, EmployeeDTO dto) {
        Employee entity = repository.findById((long) id.intValue()).orElseThrow();
        Company company = companyRepository.findById((long) dto.getCompanyId().intValue()).orElseThrow();
        mapper.updateEntity(entity, dto, company);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById((long) id.intValue());
    }

    @Override
    public EmployeeDTO getById(Long id) {
        Employee entity = repository.findById((long) id.intValue()).orElseThrow();
        return mapper.toDTO(entity);
    }

    @Override
    public List<EmployeeDTO> getAll() {
        return repository.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }
}
