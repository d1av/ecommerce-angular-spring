package com.davi.shop.dto;

import com.davi.shop.entities.Product;
import com.davi.shop.entities.ProductCategory;
import jakarta.persistence.*;

import java.util.Set;

public class ProductCategoryDTO {
    private Long id;
    private String categoryName;
    private Set<Product> products;

    public ProductCategoryDTO(Long id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

    public ProductCategoryDTO(ProductCategory entity) {
        id = entity.getId();
        categoryName = entity.getCategoryName();
    }

    public ProductCategoryDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Set<Product> getProducts() {
        return products;
    }
}
