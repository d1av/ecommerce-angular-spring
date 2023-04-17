package com.davi.shop.resources;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.davi.shop.dto.controller.location.CountryDTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@RequestMapping(value = "/api/v1/countries")
public interface CountryAPI {

    @GetMapping
    public ResponseEntity<Page<CountryDTO>> getAllPaged(
	    Pageable pageable);

    @GetMapping(value = "/{id}")
    public ResponseEntity<CountryDTO> getOneById(
	    @PathVariable(required = true) @NotNull @Min(1) @Max(300) Long id);
}
