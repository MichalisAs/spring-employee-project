package com.example.demo.service;

import com.example.demo.dto.CompanyDTO;

import java.util.List;

public interface CompanyService {

    CompanyDTO create(CompanyDTO dto);

    CompanyDTO update(Long id, CompanyDTO dto);

    void delete(Long id);

    CompanyDTO getById(Long id);

    List<CompanyDTO> getAll();

    Double calculateMonthlyExpenses(Long companyId);
}
