package com.davi.shop.dto;

import com.davi.shop.entities.ProductCategory;

public class ProductCategoryDTO {
    private Long id;
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
