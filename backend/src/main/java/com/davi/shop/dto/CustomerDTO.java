package com.davi.shop.dto;

import com.davi.shop.entities.Customer;

public class CustomerDTO {
    private String firstName;
    private String lastName;
    private String email;

    public CustomerDTO() {
    }

    public CustomerDTO(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public CustomerDTO(Customer entity) {
        firstName = entity.getFirstName();
        lastName = entity.getLastName();
        email = entity.getEmail();
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
