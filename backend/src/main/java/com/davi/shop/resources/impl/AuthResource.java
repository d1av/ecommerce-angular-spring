package com.davi.shop.resources.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.davi.shop.dto.controller.auth.JWTAuthResponse;
import com.davi.shop.dto.controller.auth.LoginDTO;
import com.davi.shop.dto.controller.auth.RegisterDTO;
import com.davi.shop.dto.controller.auth.RegisterResponseDTO;
import com.davi.shop.dto.service.LoginRolesResponseDTO;
import com.davi.shop.resources.AuthAPI;
import com.davi.shop.services.AuthService;

import jakarta.validation.Valid;

@RestController
public class AuthResource implements AuthAPI {

    private AuthService authService;

    public AuthResource(AuthService authService) {
	this.authService = authService;
    }

    public ResponseEntity<JWTAuthResponse> login(LoginDTO loginDTO) {
	LoginRolesResponseDTO response = authService.login(loginDTO);

	return ResponseEntity.ok(
		JWTAuthResponse.with(loginDTO.getUsernameOrEmail(),
			response.getToken(), response.getRoles()));
    }

     public ResponseEntity<RegisterResponseDTO> register(RegisterDTO registerDTO) {
	return new ResponseEntity<>(
		RegisterResponseDTO
			.from(authService.register(registerDTO)),
		HttpStatus.CREATED);
    }
}
