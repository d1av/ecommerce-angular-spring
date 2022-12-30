package com.davi.shop.services;

import com.davi.shop.dto.PurchaseInsertDTO;
import com.davi.shop.dto.PurchaseShowDTO;
import com.davi.shop.entities.*;
import com.davi.shop.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
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

    @Autowired
    private PurchaseRepository purchaseRepository;


    public PurchaseInsertDTO insert(PurchaseInsertDTO dto) {
        Address shippingAddress = addressRepository.save(dto.getShippingAddress());
        Address billingAddress = addressRepository.save(dto.getBillingAddress());
        Customer customer = customerRepository.save(dto.getCustomer());
        Orders orders = new Orders(dto, shippingAddress, billingAddress, customer, "");
        dto.setOrder(ordersRepository.save(orders));
        dto.getOrderItems().stream()
                .map(x -> {
                    x.setOrders(orders);
                    return orderItemRepository.save(x);
                })
                .collect(Collectors.toList());
        return dto;
    }


}
