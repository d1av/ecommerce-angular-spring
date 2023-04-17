package com.davi.shop.repositories.location;

import org.springframework.data.jpa.repository.JpaRepository;

import com.davi.shop.entities.location.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

}
