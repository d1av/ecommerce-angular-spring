package com.davi.shop.resources;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.davi.shop.dto.controller.location.StateDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Validated
@RequestMapping(value = "/states")
public interface StateAPI {

    @GetMapping
    public ResponseEntity<Page<StateDTO>> findAllPaged(
	    Pageable pageable);
    
    @GetMapping(value = "/search")
    public ResponseEntity<List<StateDTO>> findByCountryCode(
	    @RequestParam(name = "code") @NotBlank @Size(min = 2, max = 2) String countryCode);
}
