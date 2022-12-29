package com.davi.shop.resources;

import com.davi.shop.dto.CountryDTO;
import com.davi.shop.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/countries")
public class CountryResource {

    @Autowired
    private CountryService service;

    @GetMapping
    public ResponseEntity<Page<CountryDTO>> getAllPaged(Pageable pageable) {
        return ResponseEntity.ok()
                .body(service.findAllPaged(pageable));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CountryDTO> getOneById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findOneById(id));
    }
}
