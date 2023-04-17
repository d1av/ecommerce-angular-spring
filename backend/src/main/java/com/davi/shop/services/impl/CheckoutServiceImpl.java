package com.davi.shop.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.davi.shop.dto.PaymentInfoDTO;
import com.davi.shop.dto.PurchaseDTO;
import com.davi.shop.dto.PurchaseResponseDTO;
import com.davi.shop.entities.Order;
import com.davi.shop.entities.OrderItem;
import com.davi.shop.entities.User;
import com.davi.shop.repositories.UserRepository;
import com.davi.shop.services.CheckoutService;
import com.davi.shop.utils.IDUtils;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private final UserRepository userRepository;

    public CheckoutServiceImpl(UserRepository userRepository,
	    @Value("${stripe.key.secret}") String secretKey) {
	this.userRepository = userRepository;
	Stripe.apiKey = secretKey;
    }

    @Override
    @Transactional
    public PurchaseResponseDTO placeOrder(PurchaseDTO purchase) {
	// retrieve the order
	Order order = purchase.getOrder();
	// generate tracking nuber
	String orderTrackingNumber = generateOrderTrackingNumber();
	order.setOrderTrackingNumber(orderTrackingNumber);

	// populate order with order items
	Set<OrderItem> orderItems = purchase.getOrderItems();
	orderItems.forEach(order::add);

	// populate order with billingAddress and shippingAddress
	order.setBillingAddress(purchase.getBillingAddress());
	order.setShippingAddress(purchase.getShippingAddress());

	// populate customer with order
	User user = purchase.getUser();

	String theEmail = user.getEmail();

	Optional<User> customerFromDB = userRepository
		.findByEmail(theEmail);

	if (customerFromDB.isPresent()) {
	    user = customerFromDB.get();
	}else {
	    user.setId(null);
	}

	user.add(order);

	// save to the database
	userRepository.save(user);

	// return a response
	return new PurchaseResponseDTO(orderTrackingNumber);
    }

    @Override
    public PaymentIntent createPaymentIntent(
	    PaymentInfoDTO paymentInfoDTO) throws StripeException {
	List<String> paymentMethodTypes = new ArrayList<>();
	paymentMethodTypes.add("card");

	Map<String, Object> params = new HashMap<>();
	params.put("amount", paymentInfoDTO.getAmount());
	params.put("currency", paymentInfoDTO.getCurrency());
	params.put("payment_method_types", paymentMethodTypes);
	params.put("description", "Shop Purchase");
	params.put("receipt_email", paymentInfoDTO.getReceiptEmail());
	return PaymentIntent.create(params);
    }

    private String generateOrderTrackingNumber() {
	// generate a random UUID number
	return IDUtils.GetIDValue();
    }
}
