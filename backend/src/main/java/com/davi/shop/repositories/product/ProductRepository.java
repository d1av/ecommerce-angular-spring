package com.davi.shop.repositories.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.davi.shop.entities.product.Product;
import com.davi.shop.entities.product.ProductJpaEntity;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductJpaEntity, Long> {
    Page<ProductJpaEntity> findByCategoryId(@Param("id") Long id, Pageable pageable);

    Page<ProductJpaEntity> findByNameContainingIgnoreCase(@Param("name") String name, Pageable pageable);

    Optional<ProductJpaEntity> findById(Long id);
}
