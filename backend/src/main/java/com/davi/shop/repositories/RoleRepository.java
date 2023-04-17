package com.davi.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.davi.shop.entities.role.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
