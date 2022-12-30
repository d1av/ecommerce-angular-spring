package com.davi.shop.dto;

import com.davi.shop.entities.Order;

import java.math.BigDecimal;
import java.util.Date;

public class OrderDTO {
    private BigDecimal totalPrice;
    private Integer totalQuantity;
    private String orderTrackingNumber;
    private Date dateCreated;

    public OrderDTO() {
    }

    public OrderDTO(BigDecimal totalPrice, Integer totalQuantity, String orderTrackingNumber, Date dateCreated) {
        this.totalPrice = totalPrice;
        this.totalQuantity = totalQuantity;
        this.orderTrackingNumber = orderTrackingNumber;
        this.dateCreated = dateCreated;
    }

    public OrderDTO(Order entity) {
        totalPrice = entity.getTotalPrice();
        totalQuantity = entity.getTotalQuantity();
        orderTrackingNumber = entity.getOrderTrackingNumber();
        dateCreated = entity.getDateCreated();
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

    public String getOrderTrackingNumber() {
        return orderTrackingNumber;
    }

    public void setOrderTrackingNumber(String orderTrackingNumber) {
        this.orderTrackingNumber = orderTrackingNumber;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
