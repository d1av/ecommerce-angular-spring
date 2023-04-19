package com.davi.shop.repositories.product;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.davi.shop.entities.product.ProductCategory;

public interface ProductCategoryRepository
	extends JpaRepository<ProductCategory, Long> {
    
    Optional<ProductCategory> findByCategoryName(String categoryName);
}
