package com.davi.shop.services;

import com.davi.shop.dto.OrderDTO;
import com.davi.shop.entities.Order;
import com.davi.shop.repositories.OrderRepository;
import com.davi.shop.repositories.UserRepository;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository repository;

    private final UserRepository userRepository;

    public OrderService(final OrderRepository repository,
	    final UserRepository userRepository) {
	this.repository = Objects.requireNonNull(repository);
	this.userRepository = Objects.requireNonNull(userRepository);
    }

    public Page<OrderDTO> findByEmail(String email,
	    Pageable pageable) {

	Page<Order> orders = repository
		.findByCustomerEmailOrderByDateCreatedDesc(email,
			pageable);
	Page<OrderDTO> dto = orders.map(x -> new OrderDTO(x));
	return dto;
    }
}
