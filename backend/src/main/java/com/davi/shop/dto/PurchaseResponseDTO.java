package com.davi.shop.dto;

import jakarta.validation.constraints.NotBlank;

public class PurchaseResponseDTO {
    
    @NotBlank(message = "'orderTrackingNumber' should not be empty.")
    private String orderTrackingNumber;

    public PurchaseResponseDTO(String orderTrackingNumber) {
        this.orderTrackingNumber = orderTrackingNumber;
    }

    public String getOrderTrackingNumber() {
        return orderTrackingNumber;
    }

    public void setOrderTrackingNumber(String orderTrackingNumber) {
        this.orderTrackingNumber = orderTrackingNumber;
    }
}
