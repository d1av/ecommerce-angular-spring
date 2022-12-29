package com.davi.shop.services;

import com.davi.shop.dto.StateDTO;
import com.davi.shop.entities.State;
import com.davi.shop.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StateService {

    @Autowired
    private StateRepository repository;

    @Transactional(readOnly = true)
    public Page<StateDTO> findAllPaged(Pageable pageable) {
        Page<State> state = repository.findAll(pageable);
        Page<StateDTO> dto = state.map(x -> new StateDTO(x));
        return dto;
    }

    @Transactional(readOnly = true)
    public List<StateDTO> findAllByCountryCode(String countryCode) {
        List<State> state = repository.findByCountryCode(countryCode);
        List<StateDTO> dto = state.stream().map(x -> new StateDTO(x))
                .collect(Collectors.toList());
        return dto;
    }

}
