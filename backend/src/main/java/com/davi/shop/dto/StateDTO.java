package com.davi.shop.dto;

import com.davi.shop.entities.State;

import jakarta.validation.constraints.NotBlank;

public class StateDTO {
    
    @NotBlank(message = "'id' should not be empty.")
    private Long id;
    
    @NotBlank(message = "'name' should not be empty.")
    private String name;
    
    @NotBlank(message = "'countryId' should not be empty.")
    private Long countryId;

    public StateDTO() {
    }

    public StateDTO(Long id, String name, Long countryId) {
        this.id = id;
        this.name = name;
        this.countryId = countryId;
    }

    public StateDTO(State entity) {
        id = entity.getId();
        name = entity.getName();
        countryId = entity.getCountry().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }
}
