package com.davi.shop.entities.product;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.davi.shop.entities.productcat.ProductCategory;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class ProductJpaEntity {

    @Column(name = "id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private ProductCategory category;

    @Column(name = "sku", nullable = false)
    private String sku;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "units_in_stock")
    private Integer unitsInStock;

    @CreationTimestamp
    @Column(name = "date_created")
    private Date dateCreated;

    @UpdateTimestamp
    @Column(name = "last_updated")
    private Date lastUpdated;

    public ProductJpaEntity() {
    }

    private ProductJpaEntity(Long id, ProductCategory category,
	    String sku, String name, String description,
	    BigDecimal unitPrice, String imageUrl, Boolean active,
	    Integer unitsInStock, Date dateCreated,
	    Date lastUpdated) {
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
    }

    public static ProductJpaEntity from(Product product) {
	return new ProductJpaEntity(product.getId(),
		product.getCategory(), product.getSku(),
		product.getName(), product.getDescription(),
		product.getUnitPrice(), product.getImageUrl(),
		product.getActive(), product.getUnitsInStock(),
		product.getDateCreated(), product.getLastUpdated());
    }

    public Product toAggregate() {
	return Product.with(getId(), getCategory(), getSku(),
		getName(), getDescription(), getUnitPrice(),
		getImageUrl(), getActive(), getUnitsInStock(),
		getDateCreated(), getLastUpdated());
    }

    public ProductCategory getCategory() {
	return category;
    }

    public void setCategory(ProductCategory category) {
	this.category = category;
    }

    public Boolean getActive() {
	return active;
    }

    public void setActive(Boolean active) {
	this.active = active;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
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

    public boolean isActive() {
	return active;
    }

    public void setActive(boolean active) {
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

    @Override
    public boolean equals(Object o) {
	if (this == o)
	    return true;
	if (!(o instanceof ProductJpaEntity product))
	    return false;
	return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
	return Objects.hash(id);
    }

}
