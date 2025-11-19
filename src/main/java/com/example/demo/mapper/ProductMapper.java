package com.example.demo.mapper;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    // Convert Entity -> DTO
    public ProductDTO toDTO(Product entity) {
        if (entity == null) return null;

        ProductDTO dto = new ProductDTO();
        dto.setId(entity.getId());       // safe: read-only
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setBarcode(entity.getBarcode());

        return dto;
    }

    // Convert DTO -> Entity
    public Product toEntity(ProductDTO dto) {
        if (dto == null) return null;

        Product entity = new Product();
        // DO NOT set ID for new entity to avoid breaking DB
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setBarcode(dto.getBarcode());

        return entity;
    }
}
