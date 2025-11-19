package com.example.demo.controller;

import com.example.demo.dto.BonusDTO;
import com.example.demo.service.BonusService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bonuses")
public class BonusController {

    private final BonusService service;

    public BonusController(BonusService service) {
        this.service = service;
    }

    @PostMapping
    public BonusDTO create(@RequestBody BonusDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public BonusDTO update(@PathVariable Long id, @RequestBody BonusDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    public BonusDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<BonusDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/calculate")
    public Double calculateBonus(@RequestParam Double salary, @RequestParam String season) {
        return service.calculateBonus(salary, season);
    }

    @GetMapping("/create-for-company")
    public List<BonusDTO> createBonusesForCompany(@RequestParam Long companyId, @RequestParam String season) {
        return service.createBonusesForCompany(companyId, season);
    }
}
