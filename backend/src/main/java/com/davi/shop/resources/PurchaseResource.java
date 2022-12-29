package com.davi.shop.resources;

import com.davi.shop.dto.PurchaseInsertDTO;
import com.davi.shop.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/purchase")
public class PurchaseResource {

    @Autowired
    private PurchaseService service;

    @PostMapping
    public ResponseEntity<PurchaseInsertDTO> saveOne(@RequestBody PurchaseInsertDTO dto) {
        return ResponseEntity.ok().body(service.insert(dto));
    }
}
