package com.davi.shop.resources;

import com.davi.shop.dto.PurchaseDTO;
import com.davi.shop.dto.PurchaseResponseDTO;
import com.davi.shop.services.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/checkout")
public class CheckoutResource {

    @Autowired
    private CheckoutService service;

    @PostMapping("/purchase")
    public ResponseEntity<PurchaseResponseDTO> placeOrder(@RequestBody PurchaseDTO purchase) {
        PurchaseResponseDTO purchaseResponse = service.placeOrder(purchase);
        return ResponseEntity.ok().body(purchaseResponse);
    }
}
