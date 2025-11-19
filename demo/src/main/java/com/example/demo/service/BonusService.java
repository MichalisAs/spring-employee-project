package com.example.demo.service;

import com.example.demo.dto.BonusDTO;

import java.util.List;

public interface BonusService {

    BonusDTO create(BonusDTO dto);

    BonusDTO update(Long id, BonusDTO dto);

    void delete(Long id);

    BonusDTO getById(Long id);

    List<BonusDTO> getAll();

    Double calculateBonus(Double salary, String season);

    List<BonusDTO> createBonusesForCompany(Long companyId, String season);
}
