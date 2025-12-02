package com.example.demo.mapper;

import com.example.demo.dto.BonusDTO;
import com.example.demo.entity.Bonus;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BonusMapper {

    private final ModelMapper modelMapper = new ModelMapper();

    public BonusDTO toDTO(Bonus entity) {

        return modelMapper.map(entity, BonusDTO.class);
    }

    public Bonus toEntity(BonusDTO dto) {

        return modelMapper.map(dto, Bonus.class);
    }
}
