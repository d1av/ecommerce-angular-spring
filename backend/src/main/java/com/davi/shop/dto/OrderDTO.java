package com.davi.shop.dto;

import com.davi.shop.entities.Order;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.Date;

public class OrderDTO {

    @NotNull(message = "'totalPrice' should not be empty.")
    private BigDecimal totalPrice;

    @NotNull
    @Min(1)
    @Max(99999)
    private Integer totalQuantity;

    @Size(min = 1, max = 100)
    @NotBlank(message = "'orderTrackingNumber' should not be empty.")
    private String orderTrackingNumber;

    @NotNull(message = "'dateCreated' should not be empty.")
    private Date dateCreated;

    public OrderDTO() {
    }

    public OrderDTO(BigDecimal totalPrice, Integer totalQuantity,
	    String orderTrackingNumber, Date dateCreated) {
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
