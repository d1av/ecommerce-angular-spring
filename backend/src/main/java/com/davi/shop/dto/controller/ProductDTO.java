package com.davi.shop.dto.controller;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Date;

import com.davi.shop.entities.product.Product;

public class ProductDTO {
    
    @NotNull(message = "'id' should not be empty.")
    private Long id;
    
    @NotBlank(message = "'name' should not be empty.")
    private String name;
    
    @NotBlank(message = "'sku' should not be empty.")
    private String sku;
    
    @NotBlank(message = "'description' should not be empty.")
    private String description;
    
    @NotNull(message = "'unitPrice' should not be empty.")
    private BigDecimal unitPrice;
    
    @NotBlank(message = "'imageUrl' should not be empty.")
    private String imageUrl;
    
    @NotNull(message = "'active' should not be empty.")
    private Boolean active;
    
    @NotNull(message = "'unitsInStock' should not be empty.")
    private Integer unitsInStock;
    
    @NotNull(message = "'dateCreated' should not be empty.")
    private Date dateCreated;
    
    @NotBlank(message = "'lastUpdated' should not be empty.")
    private Date lastUpdated;
    
    @NotBlank(message = "'category' should not be empty.")
    private ProductCategoryDTO category;

    public ProductDTO() {
    }

    public ProductDTO(Long id, String name, String sku, String description, BigDecimal unitPrice, String imageUrl, Boolean active, Integer unitsInStock, Date dateCreated, Date lastUpdated, ProductCategoryDTO category) {
        this.id = id;
        this.name = name;
        this.sku = sku;
        this.description = description;
        this.unitPrice = unitPrice;
        this.imageUrl = imageUrl;
        this.active = active;
        this.unitsInStock = unitsInStock;
        this.dateCreated = dateCreated;
        this.lastUpdated = lastUpdated;
        this.category = category;
    }

    public ProductDTO(Product entity) {
        id = entity.getId();
        category = new ProductCategoryDTO(entity.getCategory());
        sku = entity.getSku();
        name = entity.getName();
        description = entity.getDescription();
        unitPrice = entity.getUnitPrice();
        imageUrl = entity.getImageUrl();
        active = entity.getActive();
        unitsInStock = entity.getUnitsInStock();
        dateCreated = entity.getDateCreated();
        lastUpdated = entity.getLastUpdated();
        this.category = new ProductCategoryDTO(entity.getCategory());
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public ProductCategoryDTO getCategory() {
        return category;
    }

    public void setCategory(ProductCategoryDTO category) {
        this.category = category;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(Integer unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
