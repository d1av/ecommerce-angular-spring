package com.davi.shop.dto;

import com.davi.shop.entities.Address;
import com.davi.shop.entities.Customer;
import com.davi.shop.entities.OrderItem;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import com.davi.shop.entities.Order;

import java.util.List;
import java.util.Set;

public class PurchaseDTO {
    
    @NotNull(message = "'customer' should not be empty.")
    private Customer customer;
    
    @NotNull(message = "'shippingAddress' should not be empty.")
    private Address shippingAddress;
    
    @NotNull(message = "'billingAddress' should not be empty.")
    private Address billingAddress;
    
    @NotNull(message = "'order' should not be empty.")
    private Order order;
    
    @NotNull(message = "'orderItems' should not be empty.")
    private Set<OrderItem> orderItems;

    public PurchaseDTO() {
    }

    public PurchaseDTO(Customer customer, Address shippingAddress, Address billingAddress, Order order, Set<OrderItem> orderItems) {
        this.customer = customer;
        this.shippingAddress = shippingAddress;
        this.billingAddress = billingAddress;
        this.order = order;
        this.orderItems = orderItems;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
