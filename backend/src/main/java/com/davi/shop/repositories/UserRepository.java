package com.davi.shop.repositories;

import com.davi.shop.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsernameOrEmail(String usernameOrEmail, String usernameOrEmail1);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
