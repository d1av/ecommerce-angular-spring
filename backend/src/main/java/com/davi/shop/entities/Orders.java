package com.davi.shop.entities;

import com.davi.shop.dto.PurchaseInsertDTO;
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
    private String orderTrackingNumber;
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

    public Orders(Long id, String orderTrackingNumber, BigDecimal totalPrice, Integer totalQuantity, Address billingAddress, Address shippingAddress, Customer customer, String status, Date dateCreated, Date lastUpdated) {
        this.id = id;
        this.orderTrackingNumber = orderTrackingNumber;
        this.totalPrice = totalPrice;
        this.totalQuantity = totalQuantity;
        this.billingAddress = billingAddress;
        this.shippingAddress = shippingAddress;
        this.customer = customer;
        this.status = status;
        this.dateCreated = dateCreated;
        this.lastUpdated = lastUpdated;
    }

    public Orders(PurchaseInsertDTO entity, Address shippingAddress, Address billingAddress,Customer customer, String status) {
        this.totalPrice = entity.getOrder().getTotalPrice();
        this.totalQuantity = entity.getOrder().getTotalQuantity();
        this.billingAddress = shippingAddress;
        this.shippingAddress = billingAddress;
        this.customer = customer;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderTrackingNumber() {
        return orderTrackingNumber;
    }

    public void setOrderTrackingNumber(String orderTrackingNumber) {
        this.orderTrackingNumber = orderTrackingNumber;
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
