package com.davi.shop.resources;

import com.davi.shop.dto.ProductDTO;
import com.davi.shop.entities.Product;
import com.davi.shop.services.ProductService;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping(value = "/products")
public class ProductResources {

    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<Page<ProductDTO>> findAllPaged(
	    Pageable pageable) {
	return ResponseEntity.ok()
		.body(service.findAllPaged(pageable));
    }

    @GetMapping(value = "/search/category")
    public ResponseEntity<Page<Product>> findAllPaged(
	    @RequestParam("id") @NotBlank @Size(min = 1, max = 100) Long id,
	    Pageable pageable) {
	return ResponseEntity.ok()
		.body(service.findByCategoryId(id, pageable));
    }

    @GetMapping(value = "/search")
    public ResponseEntity<Page<Product>> seachByName(
	    @RequestParam("name") @NotBlank @Size(min = 1, max = 100) String name,
	    Pageable pageable0) {
	return ResponseEntity.ok()
		.body(service.findByName(name, pageable0));
    }

    @GetMapping(value = "/search/{id}")
    public ResponseEntity<ProductDTO> searchById(
	    @PathVariable @NotBlank @Size(min = 1, max = 100) Long id,
	    Pageable pageable) {
	return ResponseEntity.ok().body(service.findById(id));
    }
}
