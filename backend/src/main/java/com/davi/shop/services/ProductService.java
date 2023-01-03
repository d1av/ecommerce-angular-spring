package com.davi.shop.services;

import com.davi.shop.dto.ProductDTO;
import com.davi.shop.entities.Product;
import com.davi.shop.repositories.ProductRepository;
import com.davi.shop.exceptions.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Page<ProductDTO> findAllPaged(Pageable pageable) {
        Page<Product> entity = repository.findAll(pageable);
        Page<ProductDTO> dto = entity.map(x -> new ProductDTO(x));
        return dto;
    }

    public Page<Product> findByCategoryId(Long id, Pageable pageable) {
        Page<Product> entity;
        if (id == null || id < 0) {
            entity = repository.findAll(pageable);
        } else {
            entity = repository.findByCategoryId(id, pageable);
        }
        ;
        return entity;
    }

    public Page<Product> findByName(String name, Pageable pageable) {
        return repository.findByNameContainingIgnoreCase(name, pageable);
    }

    public ProductDTO findById(Long id) {
        Product entity = repository.findById(id).orElseThrow(() -> new DataNotFoundException("User id not found."));
        return new ProductDTO(entity);
    }
}
