package com.davi.shop.resources;

import com.davi.shop.dto.ProductCategoryDTO;
import com.davi.shop.services.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/product-categories")
public class ProductCategoryResources {

    @Autowired
    private ProductCategoryService service;

    @GetMapping
    public ResponseEntity<Page<ProductCategoryDTO>> findAllPaged(Pageable pageable) {
        return ResponseEntity.ok().body(service.findAllPaged(pageable));
    }
}
