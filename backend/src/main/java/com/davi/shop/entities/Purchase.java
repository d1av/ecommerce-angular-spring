package com.davi.shop.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long customerId;
    private Long shippingAddressId;
    private Long billingAddressId;
    private Long orders;
    private List<Long> orderItems;

    public Purchase() {
    }

    public Purchase(Long id, Long customerId, Long shippingAddressId, Long billingAddressId, Long orders, List<Long> orderItems) {
        this.id = id;
        this.customerId = customerId;
        this.shippingAddressId = shippingAddressId;
        this.billingAddressId = billingAddressId;
        this.orders = orders;
        this.orderItems = orderItems;
    }

    public Purchase(Customer customer, Address shippingAddress, Address billingAddress,
                    Order order, List<OrderItem> orderItems) {
        this.customerId = customer.getId();
        this.shippingAddressId = shippingAddress.getId();
        this.billingAddressId = billingAddress.getId();
        this.orders = order.getId();
        this.orderItems = orderItems.stream().map(x-> x.getId()).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getShippingAddressId() {
        return shippingAddressId;
    }

    public void setShippingAddressId(Long shippingAddressId) {
        this.shippingAddressId = shippingAddressId;
    }

    public Long getBillingAddressId() {
        return billingAddressId;
    }

    public void setBillingAddressId(Long billingAddressId) {
        this.billingAddressId = billingAddressId;
    }

    public Long getOrders() {
        return orders;
    }

    public void setOrders(Long orders) {
        this.orders = orders;
    }

    public List<Long> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<Long> orderItems) {
        this.orderItems = orderItems;
    }
}
