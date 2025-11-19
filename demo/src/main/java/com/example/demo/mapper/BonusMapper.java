package com.example.demo.mapper;

import com.example.demo.dto.BonusDTO;
import com.example.demo.entity.Bonus;
import org.springframework.stereotype.Component;

@Component
public class BonusMapper {

    public BonusDTO toDTO(Bonus entity) {
        if (entity == null) return null;
        BonusDTO dto = new BonusDTO();
        dto.setId(entity.getId());
        dto.setEmployeeId(entity.getEmployee().getId());
        dto.setCompanyId(entity.getCompany().getId());
        dto.setAmount(entity.getAmount());
        return dto;
    }

    public Bonus toEntity(BonusDTO dto) {
        if (dto == null) return null;
        Bonus entity = new Bonus();
        entity.setId(dto.getId());
        entity.setAmount(dto.getAmount());
        return entity;
    }
}
