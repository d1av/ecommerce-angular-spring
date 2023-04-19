package com.davi.shop.entities.product;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import com.davi.shop.entities.productcat.ProductCategory;
import com.davi.shop.exceptions.NotificationException;
import com.davi.shop.utils.InstantUtils;
import com.davi.shop.validation.Notification;
import com.davi.shop.validation.ValidationHandler;

public class Product {

    private Long id;

    private ProductCategory category;

    private String sku;

    private String name;

    private String description;

    private BigDecimal unitPrice;

    private String imageUrl;

    private Boolean active;

    private Integer unitsInStock;

    private Date dateCreated;

    private Date lastUpdated;

    private Product(Long id, ProductCategory category, String sku,
	    String name, String description, BigDecimal unitPrice,
	    String imageUrl, Boolean active, Integer unitsInStock,
	    Date dateCreated, Date lastUpdated) {
	this.id = id;
	this.category = category;
	this.sku = sku;
	this.name = name;
	this.description = description;
	this.unitPrice = unitPrice;
	this.imageUrl = imageUrl;
	this.active = active;
	this.unitsInStock = unitsInStock;
	this.dateCreated = dateCreated;
	this.lastUpdated = lastUpdated;

	selfValidate();
    }

    public Product update(ProductCategory category, String sku,
	    String name, String description, BigDecimal unitPrice,
	    String imageUrl, Boolean active, Integer unitsInStock) {

	this.category = category;
	this.sku = sku;
	this.name = name;
	this.description = description;
	this.unitPrice = unitPrice;
	this.imageUrl = imageUrl;
	this.active = active;
	this.unitsInStock = unitsInStock;
	this.lastUpdated = Date.from(InstantUtils.now());

	selfValidate();
	
	return this;
    }

    public static Product create(ProductCategory category, String sku,
	    String name, String description, BigDecimal unitPrice,
	    String imageUrl, Boolean active, Integer unitsInStock) {
	return new Product(null, category, sku, name, description,
		unitPrice, imageUrl, active, unitsInStock,
		InstantUtils.dateNow(), InstantUtils.dateNow());
    }

    public static Product with(Long id, ProductCategory category,
	    String sku, String name, String description,
	    BigDecimal unitPrice, String imageUrl, Boolean active,
	    Integer unitsInStock, Date dateCreated,
	    Date lastUpdated) {
	return new Product(id, category, sku, name, description,
		unitPrice, imageUrl, active, unitsInStock,
		dateCreated, lastUpdated);
    }

    public void validate(ValidationHandler handler) {
	new ProductValidator(this, handler).validate();
    }
    
    private void selfValidate() {
	final var notification = Notification.create();
	validate(notification);

	if (notification.hasError()) {
	    throw new NotificationException(
		    "Failed to validate Aggregate FixedTax",
		    notification);
	}	
    }    
    
    public Long getId() {
	return id;
    }

    public ProductCategory getCategory() {
	return category;
    }

    public String getSku() {
	return sku;
    }

    public String getName() {
	return name;
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

    public Boolean getActive() {
	return active;
    }

    public Integer getUnitsInStock() {
	return unitsInStock;
    }

    public Date getDateCreated() {
	return dateCreated;
    }

    public Date getLastUpdated() {
	return lastUpdated;
    }

    @Override
    public int hashCode() {
	return Objects.hash(id, name);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Product other = (Product) obj;
	return Objects.equals(id, other.id)
		&& Objects.equals(name, other.name);
    }

}
