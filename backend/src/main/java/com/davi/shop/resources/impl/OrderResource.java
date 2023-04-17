package com.davi.shop.resources.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.davi.shop.dto.controller.OrderDTO;
import com.davi.shop.services.OrderService;

@RestController
@RequestMapping(value = "/api/v1/orders")
public class OrderResource {

    @Autowired
    private OrderService service;

    @GetMapping(value = "/search")
    public ResponseEntity<Page<OrderDTO>> findSalesByLoggedUser(
	    Pageable pageable) {

	Authentication authenticationToken = SecurityContextHolder
		.getContext().getAuthentication();
	System.out.println(authenticationToken.getName());

	return ResponseEntity.ok().body(service.findByEmail(
		authenticationToken.getName(), pageable));
    }
}
