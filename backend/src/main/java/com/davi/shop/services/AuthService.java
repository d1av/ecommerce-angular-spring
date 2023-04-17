package com.davi.shop.services;

import com.davi.shop.dto.auth.LoginDTO;
import com.davi.shop.dto.auth.RegisterDTO;
import com.davi.shop.entities.User;

public interface AuthService {
    String login(LoginDTO loginDto);

    User register(RegisterDTO registerDto);
}
