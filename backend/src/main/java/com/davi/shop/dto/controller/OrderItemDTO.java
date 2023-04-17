package com.davi.shop.dto.controller;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

import com.davi.shop.entities.order.OrderItem;

public class OrderItemDTO {
    
    @NotBlank(message = "'imageUrl' should not be empty.")
    private String imageUrl;
    
    @NotNull(message = "'quantity' should not be empty.")
    private Integer quantity;
    
    @NotNull(message = "'unitPrice' should not be empty.")
    private BigDecimal unitPrice;
    
    @NotNull(message = "'productId' should not be empty.")
    private Long productId;

    public OrderItemDTO() {
    }

    public OrderItemDTO(String imageUrl, Integer quantity, BigDecimal unitPrice, Long productId) {
        this.imageUrl = imageUrl;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.productId = productId;
    }

    public OrderItemDTO(OrderItem entity) {
        imageUrl = entity.getImageUrl();
        quantity = entity.getQuantity();
        unitPrice = entity.getUnitPrice();
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
