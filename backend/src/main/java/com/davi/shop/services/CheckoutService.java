package com.davi.shop.services;

import com.davi.shop.dto.PurchaseDTO;
import com.davi.shop.dto.PurchaseResponseDTO;

public interface CheckoutService {
    PurchaseResponseDTO placeOrder(PurchaseDTO purchase);
}
