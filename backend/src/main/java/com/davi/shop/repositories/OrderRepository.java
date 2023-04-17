package com.davi.shop.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.davi.shop.entities.order.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Page<Order> findByUserEmailOrderByDateCreatedDesc(@Param("email") String email, Pageable pageable);
}
