package com.davi.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.davi.shop.entities.order.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
