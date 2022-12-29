package com.davi.shop.dto;

import java.util.List;

public class PurchaseDTO {
    private CustomerDTO customer;
    private AddressDTO shippingAddress;
    private AddressDTO billingAddress;
    private OrdersDTO order;
    private List<OrderItemDTO> orderItems;

    public PurchaseDTO() {
    }

    public PurchaseDTO(CustomerDTO customer, AddressDTO shippingAddress, AddressDTO billingAddress, OrdersDTO order, List<OrderItemDTO> orderItems) {
        this.customer = customer;
        this.shippingAddress = shippingAddress;
        this.billingAddress = billingAddress;
        this.order = order;
        this.orderItems = orderItems;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public AddressDTO getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(AddressDTO shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public AddressDTO getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(AddressDTO billingAddress) {
        this.billingAddress = billingAddress;
    }

    public OrdersDTO getOrder() {
        return order;
    }

    public void setOrder(OrdersDTO order) {
        this.order = order;
    }

    public List<OrderItemDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDTO> orderItems) {
        this.orderItems = orderItems;
    }
}
