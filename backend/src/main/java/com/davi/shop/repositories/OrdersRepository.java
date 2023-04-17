package com.davi.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.davi.shop.entities.order.Order;

public interface OrdersRepository extends JpaRepository<Order, Long> {

}
