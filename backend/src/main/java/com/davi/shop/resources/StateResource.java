package com.davi.shop.resources;

import com.davi.shop.dto.StateDTO;
import com.davi.shop.services.StateService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping(value = "/states")
public class StateResource {

    @Autowired
    private StateService service;

    @GetMapping
    public ResponseEntity<Page<StateDTO>> findAllPaged(
	    Pageable pageable) {
	return ResponseEntity.ok()
		.body(service.findAllPaged(pageable));
    }
    
    
    @GetMapping(value = "/search")
    public ResponseEntity<List<StateDTO>> findByCountryCode(
	    @RequestParam(name = "code") @NotBlank @Size(min = 1, max = 2) String countryCode) {
	List<StateDTO> list = service
		.findAllByCountryCode(countryCode);
	return ResponseEntity.ok().body(list);
    }
}
