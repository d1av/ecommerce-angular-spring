package com.davi.shop.resources;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.davi.shop.dto.controller.auth.JWTAuthResponse;
import com.davi.shop.dto.controller.auth.LoginDTO;
import com.davi.shop.dto.controller.auth.RegisterDTO;
import com.davi.shop.dto.controller.auth.RegisterResponseDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@Validated
@RequestMapping("/api/auth")
public interface AuthAPI {

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Login user and get token")
    @ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Logged In successfully and returned jwt token."),
	    @ApiResponse(responseCode = "403", description = "Bad credentials"),
	    @ApiResponse(responseCode = "500", description = "A internal server error was thrown") })
    public ResponseEntity<JWTAuthResponse> login(
	    @Valid @RequestBody LoginDTO loginDTO);

    @PostMapping(value = { "/register", "/signup" })
    @Operation(summary = "Create a new User on the platform")
    @ApiResponses(value = {
	    @ApiResponse(responseCode = "201", description = "Created successfully"),
	    @ApiResponse(responseCode = "422", description = "A validation error was thrown"),
	    @ApiResponse(responseCode = "500", description = "A internal server error was thrown") })
    public ResponseEntity<RegisterResponseDTO> register(
	    @Valid @RequestBody RegisterDTO registerDTO);
}
