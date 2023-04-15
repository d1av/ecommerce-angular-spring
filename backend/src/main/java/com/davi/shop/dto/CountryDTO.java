package com.davi.shop.dto;

import com.davi.shop.entities.Country;
import com.davi.shop.entities.State;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

public class CountryDTO {
    
    @NotBlank(message = "'id' should not be empty.")
    private Long id;
    
    @Size(min = 1, max = 100)
    @NotBlank(message = "'code' should not be empty.")
    private String code;
    
    @Size(min = 1, max = 100)
    @NotBlank(message = "'name' should not be empty.")
    private String name;
    @JsonIgnore
    private Set<State> states = new HashSet<State>();

    public CountryDTO() {
    }

    public CountryDTO(Long id, String code, String name, Set<State> states) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.states = states;
    }

    public CountryDTO(Country entity) {
        id = entity.getId();
        code = entity.getCode();
        name = entity.getName();
        states = entity.getStates();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<State> getStates() {
        return states;
    }

    public void setStates(Set<State> states) {
        this.states = states;
    }
}
