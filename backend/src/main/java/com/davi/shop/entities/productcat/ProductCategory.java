package com.davi.shop.entities.productcat;

import java.util.Objects;
import java.util.Set;

import com.davi.shop.entities.product.ProductJpaEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_categories")
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_name")
    private String categoryName;

    @JsonIgnore
    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private Set<ProductJpaEntity> products;

    public ProductCategory() {
    }

    public ProductCategory(Long id, String categoryName,
	    Set<ProductJpaEntity> products) {
	this.id = id;
	this.categoryName = categoryName;
	this.products = products;
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

    public Set<ProductJpaEntity> getProducts() {
	return products;
    }

    public void setProducts(Set<ProductJpaEntity> products) {
	this.products = products;
    }

    @Override
    public boolean equals(Object o) {
	if (this == o)
	    return true;
	if (!(o instanceof ProductCategory that))
	    return false;
	return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
	return Objects.hash(id);
    }
}
