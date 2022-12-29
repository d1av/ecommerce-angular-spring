package com.davi.shop.dto;

import com.davi.shop.entities.Address;
import com.davi.shop.entities.Customer;
import com.davi.shop.entities.OrderItem;
import com.davi.shop.entities.Orders;

import java.util.List;

public class PurchaseInsertDTO {
    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Orders order;
    private List<OrderItem> orderItems;

    public PurchaseInsertDTO() {
    }

    public PurchaseInsertDTO(Customer customer, Address shippingAddress, Address billingAddress, Orders order, List<OrderItem> orderItems) {
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

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
