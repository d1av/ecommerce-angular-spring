package com.davi.shop.dto.controller;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PaymentInfoDTO {

    @NotNull(message = "'amount' should not be empty.")
    private int amount;

    @NotBlank(message = "'currency' should not be empty.")
    private String currency;

    @NotBlank(message = "'receiptEmail' should not be empty.")
    private String receiptEmail;

    public PaymentInfoDTO() {
    }

    public PaymentInfoDTO(int amount, String currency,
	    String receiptEmail) {
	this.amount = amount;
	this.currency = currency;
	this.receiptEmail = receiptEmail;
    }

    public String getReceiptEmail() {
	return receiptEmail;
    }

    public void setReceiptEmail(String receiptEmail) {
	this.receiptEmail = receiptEmail;
    }

    public int getAmount() {
	return amount;
    }

    public void setAmount(int amount) {
	this.amount = amount;
    }

    public String getCurrency() {
	return currency;
    }

    public void setCurrency(String currency) {
	this.currency = currency;
    }
}
