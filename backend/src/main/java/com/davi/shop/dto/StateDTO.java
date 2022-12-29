package com.davi.shop.dto;

import com.davi.shop.entities.Country;
import com.davi.shop.entities.State;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class StateDTO {
    private Long id;
    private Long name;
    private Long countryId;

    public StateDTO() {
    }

    public StateDTO(Long id, Long name, Long countryId) {
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

    public Long getName() {
        return name;
    }

    public void setName(Long name) {
        this.name = name;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }
}
