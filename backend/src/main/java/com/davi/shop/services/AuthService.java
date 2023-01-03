package com.davi.shop.services;

import com.davi.shop.dto.auth.LoginDTO;
import com.davi.shop.dto.auth.RegisterDTO;

public interface AuthService {
    String login(LoginDTO loginDto);

    String register(RegisterDTO registerDto);
}
