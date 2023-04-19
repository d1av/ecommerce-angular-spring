package com.davi.shop.resources.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.davi.shop.dto.controller.ProductCategoryDTO;
import com.davi.shop.resources.ProductCategoryAPI;
import com.davi.shop.services.ProductCategoryService;

@RestController
public class ProductCategoryResources implements ProductCategoryAPI {

    private final ProductCategoryService service;

    public ProductCategoryResources(ProductCategoryService service) {
	this.service = service;
    }

    public ResponseEntity<Page<ProductCategoryDTO>> findAllPaged(
	    Pageable pageable) {
	return ResponseEntity.ok()
		.body(service.findAllPaged(pageable));
    }
}
