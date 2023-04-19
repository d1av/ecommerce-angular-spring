package com.davi.shop.resources.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
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

    public ResponseEntity<Page<ProductDTO>> findAllPaged(
	    Pageable pageable) {
	return ResponseEntity.ok()
		.body(service.findAllPaged(pageable));
    }

    public ResponseEntity<Page<Product>> findAllPaged(Long id,
	    Pageable pageable) {
	return ResponseEntity.ok()
		.body(service.findByCategoryId(id, pageable));
    }

    public ResponseEntity<Page<Product>> seachByName(String name,
	    Pageable pageable) {
	return ResponseEntity.ok()
		.body(service.findByName(name, pageable));
    }

    public ResponseEntity<ProductDTO> searchById(Long id,
	    Pageable pageable) {
	return ResponseEntity.ok().body(service.findById(id));
    }

    @Override
    public ResponseEntity<ProductDTO> registerProductJson(
	    RegisterProductDTO productDto) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ResponseEntity<ProductDTO> changeProductJson(
	    RegisterProductDTO productDto) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ResponseEntity<?> deleteProductJson(Long id) {
	// TODO Auto-generated method stub
	return null;
    }
}
