package com.davi.shop.services;

import com.davi.shop.dto.controller.ProductCategoryDTO;
import com.davi.shop.entities.product.ProductCategory;
import com.davi.shop.repositories.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductCategoryService {

    @Autowired
    private ProductCategoryRepository repository;

    public Page<ProductCategoryDTO> findAllPaged(Pageable pageable) {
        Page<ProductCategory> entity = repository.findAll(pageable);
        return entity.map(x -> new ProductCategoryDTO(x));
    }
}
