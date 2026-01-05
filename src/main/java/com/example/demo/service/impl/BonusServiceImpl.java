package com.example.demo.service.impl;

import com.example.demo.dto.BonusDTO;
import com.example.demo.entity.Bonus;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Company;
import com.example.demo.enums.BonusRate;
import com.example.demo.mapper.BonusMapper;
import com.example.demo.repository.BonusRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.service.BonusService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BonusServiceImpl implements BonusService {

    private final BonusRepository bonusRepository;
    private final EmployeeRepository employeeRepository;
    private final CompanyRepository companyRepository;
    private final BonusMapper mapper;

    public BonusServiceImpl(BonusRepository bonusRepository,
                            EmployeeRepository employeeRepository,
                            CompanyRepository companyRepository,
                            BonusMapper mapper) {
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
        Bonus bonus = bonusRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new RuntimeException("Bonus not found"));

        bonus.setAmount(dto.getAmount());
        // Optionally update employee/company if needed
        return mapper.toDTO(bonusRepository.save(bonus));
    }

    @Override
    public void delete(Long id) {
        bonusRepository.deleteById(Math.toIntExact(id));
    }

    @Override
    public BonusDTO getById(Long id) {
        return bonusRepository.findById(Math.toIntExact(id))
                .map(mapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Bonus not found"));
    }

    @Override
    public List<BonusDTO> getAll() {
        return bonusRepository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Double calculateBonus(Double salary, String season) {
        BonusRate rate = BonusRate.fromSeason(season);
        return salary * rate.getRate();
    }

    @Override
    public List<BonusDTO> createBonusesForCompany(Long companyId, String season) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new RuntimeException("Company not found"));

        List<Employee> employees = employeeRepository.findByCompanyId(companyId);
        BonusRate rate = BonusRate.fromSeason(season);

        List<Bonus> bonuses = employees.stream().map(emp -> {
            Bonus b = new Bonus();
            b.setEmployee(emp);
            b.setCompany(company);
            b.setAmount(BigDecimal.valueOf(emp.getSalary() * rate.getRate()));
            return b;
        }).collect(Collectors.toList());

        return bonusRepository.saveAll(bonuses)
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }
}
