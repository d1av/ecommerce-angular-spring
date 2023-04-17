package com.davi.shop.resources.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.davi.shop.dto.controller.location.CountryDTO;
import com.davi.shop.resources.CountryAPI;
import com.davi.shop.services.CountryService;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Validated
@RestController
public class CountryResource implements CountryAPI {

    @Autowired
    private CountryService service;

    public ResponseEntity<Page<CountryDTO>> getAllPaged(
	    Pageable pageable) {
	return ResponseEntity.ok()
		.body(service.findAllPaged(pageable));
    }

    
    public ResponseEntity<CountryDTO> getOneById(
	    @PathVariable(required = true) @NotNull @Min(1) @Max(300) Long id) {
	return ResponseEntity.ok().body(service.findOneById(id));
    }
}
