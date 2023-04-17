package com.davi.shop.entities.order;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.davi.shop.entities.location.Address;
import com.davi.shop.entities.user.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "order_tracking_number")
    private String orderTrackingNumber;

    @Column(name = "total_quantity", nullable = false)
    private int totalQuantity;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OrderStatus status;

    @Column(name = "date_created")
    @CreationTimestamp
    private Date dateCreated;

    @Column(name = "last_updated")
    @UpdateTimestamp
    private Date lastUpdated;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private Set<OrderItem> orderItems = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shipping_address_id", referencedColumnName = "id")
    private Address shippingAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "billing_address_id", referencedColumnName = "id")
    private Address billingAddress;

    public void add(OrderItem item) {

	if (item != null) {
	    if (orderItems == null) {
		orderItems = new HashSet<>();
	    }

	    orderItems.add(item);
	    item.setOrder(this);
	}
    }

    public Order() {
    }

    public Order(Long id, String orderTrackingNumber,
	    int totalQuantity, BigDecimal totalPrice,
	    OrderStatus status, Date dateCreated, Date lastUpdated,
	    Set<OrderItem> orderItems, User user,
	    Address shippingAddress, Address billingAddress) {
	this.id = id;
	this.orderTrackingNumber = orderTrackingNumber;
	this.totalQuantity = totalQuantity;
	this.totalPrice = totalPrice;
	this.status = status;
	this.dateCreated = dateCreated;
	this.lastUpdated = lastUpdated;
	this.orderItems = orderItems;
	this.user = user;
	this.shippingAddress = shippingAddress;
	this.billingAddress = billingAddress;
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

    public int getTotalQuantity() {
	return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
	this.totalQuantity = totalQuantity;
    }

    public BigDecimal getTotalPrice() {
	return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
	this.totalPrice = totalPrice;
    }

    public OrderStatus getStatus() {
	return status;
    }

    public void setStatus(OrderStatus status) {
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

    public Set<OrderItem> getOrderItems() {
	return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
	this.orderItems = orderItems;
    }

    public User getUser() {
	return user;
    }

    public void setUser(User user) {
	this.user = user;
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
}
