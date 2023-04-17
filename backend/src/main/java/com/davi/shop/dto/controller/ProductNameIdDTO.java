package com.davi.shop.dto.controller;

import com.davi.shop.entities.product.Product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductNameIdDTO {
    
    @NotNull(message = "'id' should not be empty.")
    private Long id;
    
    @NotBlank(message = "'name' should not be empty.")
    private String name;

    public ProductNameIdDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ProductNameIdDTO(Product entity) {
        id = entity.getId();
        name = entity.getName();
    }

    public ProductNameIdDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
