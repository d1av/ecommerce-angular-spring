package com.davi.shop.repositories;

import com.davi.shop.entities.Address;
import com.davi.shop.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {

}
