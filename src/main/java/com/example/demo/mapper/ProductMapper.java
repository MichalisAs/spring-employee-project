package com.example.demo.mapper;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    private final ModelMapper modelMapper = new ModelMapper();

    public ProductDTO toDTO(Product entity) {
        return modelMapper.map(entity, ProductDTO.class);
    }

    public Product toEntity(ProductDTO dto) {
        return modelMapper.map(dto, Product.class);
    }
}
