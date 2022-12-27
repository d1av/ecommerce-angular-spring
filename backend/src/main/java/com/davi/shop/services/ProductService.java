package com.davi.shop.services;

import com.davi.shop.dto.ProductDTO;
import com.davi.shop.entities.Product;
import com.davi.shop.repositories.ProductRepository;
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
        Page<ProductDTO> dto = entity.map(x->new ProductDTO(x));
        return dto;
    }
}
