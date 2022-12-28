package com.davi.shop.dto;

import com.davi.shop.entities.Product;

import java.math.BigDecimal;
import java.util.Date;

public class ProductDTO {
    private Long id;
    private String name;
    private String sku;
    private String description;
    private BigDecimal unitPrice;
    private String imageUrl;
    private Boolean active;
    private Integer unitsInStock;
    private Date dateCreated;
    private Date lastUpdated;
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
