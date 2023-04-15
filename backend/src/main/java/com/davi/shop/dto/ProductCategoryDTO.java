package com.davi.shop.dto;

import com.davi.shop.entities.ProductCategory;

import jakarta.validation.constraints.NotBlank;

public class ProductCategoryDTO {
    
    @NotBlank(message = "'id' should not be empty.")
    private Long id;
    
    @NotBlank(message = "'categoryName' should not be empty.")
    private String categoryName;


    public ProductCategoryDTO(Long id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;

    }

    public ProductCategoryDTO(ProductCategory entity) {
        id = entity.getId();
        categoryName = entity.getCategoryName();
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

}
