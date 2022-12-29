package com.davi.shop.dto;

import com.davi.shop.entities.Orders;

import java.math.BigDecimal;

public class OrdersDTO {
    private BigDecimal totalPrice;
    private Integer totalQuantity;

    public OrdersDTO() {
    }

    public OrdersDTO(BigDecimal totalPrice, Integer totalQuantity) {
        this.totalPrice = totalPrice;
        this.totalQuantity = totalQuantity;
    }

    public OrdersDTO(Orders entity) {
        totalPrice = entity.getTotalPrice();
        totalQuantity = entity.getTotalQuantity();
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Integer totalQuantity) {
        this.totalQuantity = totalQuantity;
    }
}
