package com.davi.shop.dto;

import com.davi.shop.entities.Address;
import com.davi.shop.entities.Customer;
import com.davi.shop.entities.OrderItem;
import com.davi.shop.entities.Orders;

import java.util.List;
import java.util.stream.Collectors;

public class PurchaseShowDTO {
    private CustomerDTO customer;
    private AddressDTO shippingAddress;
    private AddressDTO billingAddress;
    private OrdersDTO order;
    private List<OrderItemDTO> orderItems;

    public PurchaseShowDTO() {
    }

    public PurchaseShowDTO(CustomerDTO customer, AddressDTO shippingAddress, AddressDTO billingAddress, OrdersDTO order, List<OrderItemDTO> orderItems) {
        this.customer = customer;
        this.shippingAddress = shippingAddress;
        this.billingAddress = billingAddress;
        this.order = order;
        this.orderItems = orderItems;
    }
    public PurchaseShowDTO(Customer customer, Address shippingAddress, Address billingAddress, Orders order, List<OrderItem> orderItems) {
        this.customer = new CustomerDTO(customer);
        this.shippingAddress = new AddressDTO(shippingAddress);
        this.billingAddress = new AddressDTO(billingAddress);
        this.order = new OrdersDTO(order);
        this.orderItems = orderItems.stream().map(x->new OrderItemDTO(x)).collect(Collectors.toList());
    }
}
