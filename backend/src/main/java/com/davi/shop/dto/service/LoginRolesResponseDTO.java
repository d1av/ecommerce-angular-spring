package com.davi.shop.dto.service;

import java.util.List;

public class LoginRolesResponseDTO {

    private String token;
    private List<String> roles;

    private LoginRolesResponseDTO(String token, List<String> roles) {
	this.token = token;
	this.roles = roles;
    }

    public static LoginRolesResponseDTO with(String token,
	    List<String> roles) {
	return new LoginRolesResponseDTO(token, roles);
    }

    public String getToken() {
	return token;
    }

    public List<String> getRoles() {
	return roles;
    }

}
