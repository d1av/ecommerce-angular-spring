package com.davi.shop.dto.product;

import java.math.BigDecimal;
import java.util.Date;

import com.davi.shop.dto.controller.ProductCategoryDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RegisterProductDTO {

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

    @NotNull(message = "'unitsInStock' should not be empty.")
    private Integer unitsInStock;

    @NotBlank(message = "'category' should not be empty.")
    private ProductCategoryDTO category;

    private RegisterProductDTO(
	    @NotBlank(message = "'name' should not be empty.") String name,
	    @NotBlank(message = "'sku' should not be empty.") String sku,
	    @NotBlank(message = "'description' should not be empty.") String description,
	    @NotNull(message = "'unitPrice' should not be empty.") BigDecimal unitPrice,
	    @NotBlank(message = "'imageUrl' should not be empty.") String imageUrl,
	    @NotNull(message = "'unitsInStock' should not be empty.") Integer unitsInStock,
	    @NotBlank(message = "'category' should not be empty.") ProductCategoryDTO category) {
	super();
	this.name = name;
	this.sku = sku;
	this.description = description;
	this.unitPrice = unitPrice;
	this.imageUrl = imageUrl;
	this.unitsInStock = unitsInStock;
	this.category = category;
    }

    public static RegisterProductDTO with(String name, String sku,
	    String description, BigDecimal unitPrice, String imageUrl,
	    Integer unitsInStock, ProductCategoryDTO category) {
	return new RegisterProductDTO(name, sku, description,
		unitPrice, imageUrl, unitsInStock, category);
    }

    public String getName() {
	return name;
    }

    public String getSku() {
	return sku;
    }

    public String getDescription() {
	return description;
    }

    public BigDecimal getUnitPrice() {
	return unitPrice;
    }

    public String getImageUrl() {
	return imageUrl;
    }

    public Integer getUnitsInStock() {
	return unitsInStock;
    }

    public ProductCategoryDTO getCategory() {
	return category;
    }

}
