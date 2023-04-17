package com.davi.shop.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.davi.shop.dto.controller.PaymentInfoDTO;
import com.davi.shop.dto.controller.PurchaseDTO;
import com.davi.shop.dto.controller.PurchaseResponseDTO;
import com.stripe.exception.StripeException;

import jakarta.validation.Valid;

@Validated
@RequestMapping(value = "/api/v1/checkout")
public interface CheckoutAPI {

    @PostMapping("/purchase")
    public ResponseEntity<PurchaseResponseDTO> placeOrder(@Valid @RequestBody PurchaseDTO purchase);
    
    @PostMapping("/payment-intent")
    public ResponseEntity<String> createPaymentIntent(@Valid @RequestBody PaymentInfoDTO paymentInfo) throws StripeException;
    
}
