package com.davi.shop.repositories.location;

import org.springframework.data.jpa.repository.JpaRepository;

import com.davi.shop.entities.location.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
