package com.davi.shop.resources;

import com.davi.shop.dto.auth.JWTAuthResponse;
import com.davi.shop.dto.auth.LoginDTO;
import com.davi.shop.dto.auth.RegisterDTO;
import com.davi.shop.dto.auth.RegisterResponseDTO;
import com.davi.shop.dto.service.LoginRolesResponseDTO;
import com.davi.shop.entities.User;
import com.davi.shop.services.AuthService;

import jakarta.validation.Valid;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/api/auth")
public class AuthResource {

    private AuthService authService;

    public AuthResource(AuthService authService) {
	this.authService = authService;
    }

    @PostMapping(value = { "/login", "/signin" })
    public ResponseEntity<JWTAuthResponse> login(
	    @Valid @RequestBody LoginDTO loginDTO) {
	LoginRolesResponseDTO response = authService.login(loginDTO);

	return ResponseEntity.ok(
		JWTAuthResponse.with(loginDTO.getUsernameOrEmail(),
			response.getToken(), response.getRoles()));
    }

    @PostMapping(value = { "/register", "/signup" })
    public ResponseEntity<RegisterResponseDTO> register(
	    @Valid @RequestBody RegisterDTO registerDTO) {
	return new ResponseEntity<>(
		RegisterResponseDTO
			.from(authService.register(registerDTO)),
		HttpStatus.CREATED);
    }
}
