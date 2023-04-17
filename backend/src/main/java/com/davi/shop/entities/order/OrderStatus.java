package com.davi.shop.entities.order;

public enum OrderStatus {
    PENDING("Pending"), AWAITING_PAYMENT("Awaiting Payment"),
    AWAITING_FULLFILMENT("Awaiting Fulfillment"),
    AWAITING_SHIPMENT("Awaiting Shipment"),
    AWAITING_PICKUP("Awaiting Pickup"),
    PARTIALLY_SHIPPED("Partially Shipped"), COMPLETED("Completed"),
    SHIPPED("Shipped"), CANCELLED("Cancelled"), DECLINED("Declined"),
    REFUNDED("Refunded"), DISPUTED("Disputed"),
    MANUAL_VERIFICATION_REQUIRED("Manual Verification Required"),
    PARTIALLY_REFUNDED("Partially Refunded");

    private final String value;

    OrderStatus(String value) {
	this.value = value;
    }

    public String getValue() {
	return value;
    }
}
