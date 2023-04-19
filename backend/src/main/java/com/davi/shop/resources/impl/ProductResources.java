package com.davi.shop.resources.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.HeadersBuilder;
import org.springframework.web.bind.annotation.RestController;

import com.davi.shop.dto.controller.ProductDTO;
import com.davi.shop.dto.product.RegisterProductDTO;
import com.davi.shop.entities.product.Product;
import com.davi.shop.resources.ProductAPI;
import com.davi.shop.services.ProductService;

@RestController
public class ProductResources implements ProductAPI {

    @Autowired
    private ProductService service;

    @Override
    public ResponseEntity<Page<ProductDTO>> findAllPaged(
	    Pageable pageable) {
	return ResponseEntity.ok()
		.body(service.findAllPaged(pageable));
    }

    @Override
    public ResponseEntity<Page<Product>> findAllPaged(Long id,
	    Pageable pageable) {
	System.out.println(id);
	return ResponseEntity.ok()
		.body(service.findByCategoryId(id, pageable));
    }

    @Override
    public ResponseEntity<Page<Product>> seachByName(String name,
	    Pageable pageable) {
	return ResponseEntity.ok()
		.body(service.findByName(name, pageable));
    }

    @Override
    public ResponseEntity<ProductDTO> searchById(Long id,
	    Pageable pageable) {
	return ResponseEntity.ok().body(service.findById(id));
    }

    @Override
    public ResponseEntity<Product> registerProductJson(
	    RegisterProductDTO productDto) {
	return ResponseEntity.ok()
		.body(service.saveProductJson(productDto));
    }

    @Override
    public HeadersBuilder<?> deleteProductJson(Long id) {
	service.deleteById(id);
	return ResponseEntity.noContent();
    }

    @Override
    public ResponseEntity<Product> updateProductJson(
	    RegisterProductDTO productDto, Long id) {
	return ResponseEntity.ok()
		.body(service.updateProductJson(id, productDto));
    }
}
