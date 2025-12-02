package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {

    private Long id;
    private String name;
    private String description;
    private String barcode;

    public Object getName() {
        return null;
    }

    public Object getDescription() {
        return null;
    }

    public Object getBarcode() {
        return null;
    }
}
