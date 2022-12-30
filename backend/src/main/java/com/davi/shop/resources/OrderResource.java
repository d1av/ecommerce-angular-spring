package com.davi.shop.resources;

import com.davi.shop.dto.OrderDTO;
import com.davi.shop.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    @Autowired
    private OrderService service;

    @GetMapping(value = "/search")
    public ResponseEntity<Page<OrderDTO>> findSalesByEmail(
            @RequestParam(value = "email") String email, Pageable pageable) {
        return ResponseEntity.ok().body(service.findByEmail(email, pageable));
    }
}
