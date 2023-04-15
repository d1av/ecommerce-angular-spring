package com.davi.shop.dto.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginDTO {

    @Size(min = 1, max = 100)
    @NotBlank(message = "'usernameOrEmail' cannot be empty.")
    private String usernameOrEmail;

    @Size(min = 1, max = 35)
    @NotBlank(message = "'password' cannot be empty.")
    private String password;

    public LoginDTO(String usernameOrEmail, String password) {
	this.usernameOrEmail = usernameOrEmail;
	this.password = password;
    }

    public String getUsernameOrEmail() {
	return usernameOrEmail;
    }

    public void setUsernameOrEmail(String usernameOrEmail) {
	this.usernameOrEmail = usernameOrEmail;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }
}