package com.davi.shop.dto.controller.location;

import com.davi.shop.entities.location.Address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AddressDTO {
    
    @Size(min = 1, max = 100)
    @NotBlank(message = "'city' should not be empty.")
    private String city;
    
    @Size(min = 1, max = 100)
    @NotBlank(message = "'country' should not be empty.")
    private String country;
    
    @Size(min = 1, max = 100)
    @NotBlank(message = "'state' should not be empty.")
    private String state;
    
    @Size(min = 1, max = 100)
    @NotBlank(message = "'street' should not be empty.")
    private String street;
    
    @Size(min = 1, max = 100)
    @NotBlank(message = "'zipCode' should not be empty.")
    private String zipCode;

    public AddressDTO() {
    }

    public AddressDTO(String city, String country, String state, String street, String zipCode) {
        this.city = city;
        this.country = country;
        this.state = state;
        this.street = street;
        this.zipCode = zipCode;
    }

    public AddressDTO(Address entity) {
        this.city = entity.getCity();
        this.country = entity.getCountry();
        this.state = entity.getState();
        this.street = entity.getStreet();
        this.zipCode = entity.getZipCode();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
