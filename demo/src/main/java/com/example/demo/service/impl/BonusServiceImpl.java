package com.example.demo.service.impl;

import com.example.demo.dto.BonusDTO;
import com.example.demo.entity.Bonus;
import com.example.demo.entity.Company;
import com.example.demo.entity.Employee;
import com.example.demo.enums.BonusRate;
import com.example.demo.mapper.BonusMapper;
import com.example.demo.repository.BonusRepository;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.BonusService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BonusServiceImpl implements BonusService {

    private final BonusRepository bonusRepository;
    private final EmployeeRepository employeeRepository;
    private final CompanyRepository companyRepository;
    private final BonusMapper mapper;

    public BonusServiceImpl(BonusRepository bonusRepository, EmployeeRepository employeeRepository, CompanyRepository companyRepository, BonusMapper mapper) {
        this.bonusRepository = bonusRepository;
        this.employeeRepository = employeeRepository;
        this.companyRepository = companyRepository;
        this.mapper = mapper;
    }

    @Override
    public BonusDTO create(BonusDTO dto) {
        Bonus bonus = mapper.toEntity(dto);
        return mapper.toDTO(bonusRepository.save(bonus));
    }

    @Override
    public BonusDTO update(Long id, BonusDTO dto) {
        Bonus bonus = bonusRepository.findById(id).orElseThrow();
        bonus.setAmount(dto.getAmount());
        return mapper.toDTO(bonusRepository.save(bonus));
    }

    @Override
    public void delete(Long id) {
        bonusRepository.deleteById(id);
    }

    @Override
    public BonusDTO getById(Long id) {
        return mapper.toDTO(bonusRepository.findById(id).orElseThrow());
    }

    @Override
    public List<BonusDTO> getAll() {
        return bonusRepository.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public Double calculateBonus(Double salary, String season) {
        BonusRate rate = BonusRate.fromSeason(season);
        return salary * rate.getRate();
    }

    @Override
    public List<BonusDTO> createBonusesForCompany(Long companyId, String season) {
        Company company = companyRepository.findById(companyId.intValue()).orElseThrow();
        List<Employee> employees = employeeRepository.findByCompany(company);

        List<Bonus> bonuses = employees.stream().map(e -> {
            Bonus b = new Bonus();
            b.setEmployee(e);
            b.setCompany(company);
            double amount = e.getSalary().doubleValue() * BonusRate.fromSeason(season).getRate();
            b.setAmount(BigDecimal.valueOf(amount));
            return b;
        }).collect(Collectors.toList());

        return bonusRepository.saveAll(bonuses).stream().map(mapper::toDTO).collect(Collectors.toList());
    }
}
