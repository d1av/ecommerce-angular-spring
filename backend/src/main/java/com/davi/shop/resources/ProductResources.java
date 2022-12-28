package com.davi.shop.resources;

import com.davi.shop.dto.ProductDTO;
import com.davi.shop.entities.Product;
import com.davi.shop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/products")
public class ProductResources {

    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<Page<ProductDTO>> findAllPaged(Pageable pageable) {
        return ResponseEntity.ok().body(service.findAllPaged(pageable));
    }

    @GetMapping(value = "/search/category")
    public ResponseEntity<Page<Product>> findAllPaged(@RequestParam("id") Long id, Pageable pageable) {
        return ResponseEntity.ok().body(service.findByCategoryId(id, pageable));
    }

    @GetMapping(value = "/search")
    public ResponseEntity<Page<Product>> seachByName(@RequestParam("name") String name, Pageable pageable0) {
        return ResponseEntity.ok().body(service.findByName(name, pageable0));
    }
}
