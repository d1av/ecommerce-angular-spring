package com.davi.shop.dto;

import com.davi.shop.entities.User;
import com.stripe.model.Customer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CustomerDTO {

    @Size(min = 1, max = 100)
    @NotBlank(message = "'firstName' should not be empty.")
    private String firstName;

    @Size(min = 1, max = 100)
    @NotBlank(message = "'lastName' should not be empty.")
    private String lastName;

    @Size(min = 1, max = 100)
    @NotBlank(message = "'email' should not be empty.")
    private String email;

    public CustomerDTO() {
    }

    private CustomerDTO(String firstName, String lastName,
	    String email) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
    }

    public static CustomerDTO with(User user) {
	return new CustomerDTO(user.getFirstName(),
		user.getLastName(), user.getEmail());
    }

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }
}
