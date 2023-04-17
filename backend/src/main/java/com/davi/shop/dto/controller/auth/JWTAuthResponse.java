package com.davi.shop.dto.controller.auth;

import java.util.List;

public class JWTAuthResponse {
    private String username;
    private String accessToken;
    private String tokenType = "Bearer";
    private List<String> roles;

    private JWTAuthResponse(String accessToken, String tokenType,
	    String username, List<String> roles) {
	super();
	this.accessToken = accessToken;
	this.tokenType = tokenType;
	this.username = username;
	this.roles = roles;
    }

    public static JWTAuthResponse with(String username,
	    String accessToken, List<String> roles) {
	return new JWTAuthResponse(accessToken, "Bearer", username,
		roles);
    }

    public String getAccessToken() {
	return accessToken;
    }

    public String getTokenType() {
	return tokenType;
    }

    public String getUsername() {
	return username;
    }

    public List<String> getRoles() {
	return roles;
    }
}