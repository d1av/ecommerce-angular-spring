package com.davi.shop.repositories;

import com.davi.shop.entities.Country;
import com.davi.shop.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {

}
