package com.davi.shop.services;

import com.davi.shop.dto.auth.LoginDTO;
import com.davi.shop.dto.auth.RegisterDTO;
import com.davi.shop.dto.service.LoginRolesResponseDTO;
import com.davi.shop.entities.User;

public interface AuthService {
    LoginRolesResponseDTO login(LoginDTO loginDto);

    User register(RegisterDTO registerDto);
}
