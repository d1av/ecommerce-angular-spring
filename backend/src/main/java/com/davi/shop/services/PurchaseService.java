package com.davi.shop.services;

import com.davi.shop.dto.PurchaseDTO;
import com.davi.shop.entities.*;
import com.davi.shop.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class PurchaseService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    public PurchaseDTO insert(PurchaseDTO dto) {
        Address shippingAddress = addressRepository.save(dto.getShippingAddress());
        Address billingAddress = addressRepository.save(dto.getBillingAddress());
        Customer customer = customerRepository.save(dto.getCustomer());
        return dto;
    }


}
