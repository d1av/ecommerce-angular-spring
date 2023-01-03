package com.davi.shop.services;

import com.davi.shop.dto.CountryDTO;
import com.davi.shop.entities.Country;
import com.davi.shop.repositories.CountryRepository;
import com.davi.shop.exceptions.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository repository;

    @Transactional(readOnly = true)
    public Page<CountryDTO> findAllPaged(Pageable pageable) {
        Page<Country> found = repository.findAll(pageable);
        return found.map(x -> new CountryDTO(x));
    }

    @Transactional(readOnly = true)
    public CountryDTO findOneById(Long id) {
        Optional<Country> obj = repository.findById(id);
        Country country = obj.orElseThrow(() -> new DataNotFoundException("Country not founded."));
        return new CountryDTO(country);
    }
}
