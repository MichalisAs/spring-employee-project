package com.example.demo.mapper;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductDTO toDTO(Product entity) {
        if (entity == null) return null;
        ProductDTO dto = new ProductDTO();
        dto.setId(entity.getId()); // no conversion needed
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setBarcode(entity.getBarcode());
        return dto;
    }

    public Product toEntity(ProductDTO dto) {
        if (dto == null) return null;
        Product entity = new Product();
        entity.setId(dto.getId()); // no conversion needed
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setBarcode(dto.getBarcode());
        return entity;
    }
}
