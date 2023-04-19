package com.davi.shop.resources;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.NumberFormat;
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

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NegativeOrZero;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

@Validated
@RequestMapping(value = "/api/v1/products")
public interface ProductAPI {

    @GetMapping
    public ResponseEntity<Page<ProductDTO>> findAllPaged(
	    @RequestParam(value = "name", defaultValue = "") String name,
	    Pageable pageable);

    @GetMapping(value = "/category")
    public ResponseEntity<Page<Product>> findAllPagedByCategory(
	    @RequestParam("id") @PositiveOrZero(message = "Id must not be negative.") Long id,
	    Pageable pageable);

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> searchById(
	    @PathVariable @NotNull(message = "Id should not be null") @Min(value = 0, message = "Id must not be negative.") Long id,
	    Pageable pageable);

    @PostMapping
    public ResponseEntity<Product> registerProductJson(
	    @Valid @RequestBody RegisterProductDTO productDto);

    @PutMapping(value = "/{id}")
    public ResponseEntity<Product> updateProductJson(
	    @Valid @RequestBody RegisterProductDTO productDto,
	    @PathVariable(name = "id") @Min(value = 1, message = "Id must not be negative.") @NotNull(message = "Id should not be null") Long id);

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteProductJson(
	    @PathVariable("id") @Min(value = 1, message = "Id must not be negative.") @NotNull(message = "Id should not be null") Long id);

}
