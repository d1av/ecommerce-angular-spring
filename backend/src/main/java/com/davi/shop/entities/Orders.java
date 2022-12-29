package com.davi.shop.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String order_tracking_number;
    private BigDecimal totalPrice;
    private Integer totalQuantity;
    @ManyToOne
    @JoinColumn(name = "billing_address_id")
    private Address billingAddress;
    @ManyToOne
    @JoinColumn(name = "shipping_address_id")
    private Address shippingAddress;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    private String status;
    @CreationTimestamp
    private Date dateCreated;
    @UpdateTimestamp
    private Date lastUpdated;

    public Orders() {
    }

    public Orders(Long id, String order_tracking_number, BigDecimal totalPrice, Integer totalQuantity, Address billingAddress, Address shippingAddress, Customer customer, String status, Date dateCreated, Date lastUpdated) {
        this.id = id;
        this.order_tracking_number = order_tracking_number;
        this.totalPrice = totalPrice;
        this.totalQuantity = totalQuantity;
        this.billingAddress = billingAddress;
        this.shippingAddress = shippingAddress;
        this.customer = customer;
        this.status = status;
        this.dateCreated = dateCreated;
        this.lastUpdated = lastUpdated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrder_tracking_number() {
        return order_tracking_number;
    }

    public void setOrder_tracking_number(String order_tracking_number) {
        this.order_tracking_number = order_tracking_number;
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

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
