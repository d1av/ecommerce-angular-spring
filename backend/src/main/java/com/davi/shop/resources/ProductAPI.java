package com.davi.shop.resources;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.HeadersBuilder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.davi.shop.dto.controller.ProductDTO;
import com.davi.shop.dto.product.RegisterProductDTO;
import com.davi.shop.entities.product.Product;

import jakarta.validation.constraints.NotNull;

@Validated
@RequestMapping(value = "/api/v1/products")
public interface ProductAPI {

    @GetMapping
    public ResponseEntity<Page<ProductDTO>> findAllPaged(
	    Pageable pageable);

    @GetMapping(value = "/category")
    public ResponseEntity<Page<Product>> findAllPaged(
	    @RequestParam("id") Long id, Pageable pageable);

    @GetMapping(value = "/search")
    public ResponseEntity<Page<Product>> seachByName(
	    @RequestParam("name") String name, Pageable pageable);

    @GetMapping(value = "/search/{id}")
    public ResponseEntity<ProductDTO> searchById(
	    @PathVariable @NotNull Long id, Pageable pageable);

    @PostMapping
    public ResponseEntity<Product> registerProductJson(
	    @RequestBody RegisterProductDTO productDto);

    @PutMapping
    public ResponseEntity<Product> updateProductJson(
	    @RequestBody RegisterProductDTO productDto,
	    @RequestParam(name = "id") Long id);

    @DeleteMapping(value = "/{id}")
    public HeadersBuilder<?> deleteProductJson(
	    @RequestParam("id") Long id);

}
