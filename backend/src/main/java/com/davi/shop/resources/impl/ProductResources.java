package com.davi.shop.resources.impl;

import java.net.URI;
import java.net.URISyntaxException;

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
    public ResponseEntity<Page<ProductDTO>> findAllPaged(String name,
	    Pageable pageable) {
	if (name != null && "".equals(name.trim())) {
	    return ResponseEntity.ok().body(service
		    .findAllPaged(pageable).map(ProductDTO::from));
	} else {
	    return ResponseEntity.ok()
		    .body(service.findByName(name, pageable)
			    .map(ProductDTO::from));
	}

    }

    @Override
    public ResponseEntity<Page<ProductDTO>> findAllPagedByCategory(
	    Long id, Pageable pageable) {
	return ResponseEntity.ok()
		.body(service.findByCategoryId(id, pageable)
			.map(ProductDTO::from));
    }

    @Override
    public ResponseEntity<ProductDTO> searchById(Long id,
	    Pageable pageable) {
	return ResponseEntity.ok()
		.body(ProductDTO.from(service.findById(id)));
    }

    @Override
    public ResponseEntity<ProductDTO> registerProductJson(
	    RegisterProductDTO productDto) throws URISyntaxException {
	Product entity = service.saveProductJson(productDto);
	return ResponseEntity
		.created(
			new URI("/api/v1/products/" + entity.getId()))
		.body(ProductDTO.from(entity));
    }

    @Override
    public ResponseEntity<?> deleteProductJson(Long id) {
	service.deleteById(id);
	return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<ProductDTO> updateProductJson(
	    RegisterProductDTO productDto, Long id) {
	return ResponseEntity.ok().body(ProductDTO
		.from(service.updateProductJson(id, productDto)));
    }
}
