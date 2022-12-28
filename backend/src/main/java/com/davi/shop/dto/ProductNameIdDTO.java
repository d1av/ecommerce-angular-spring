package com.davi.shop.dto;

import com.davi.shop.entities.Product;

public class ProductNameIdDTO {
    private Long id;
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
