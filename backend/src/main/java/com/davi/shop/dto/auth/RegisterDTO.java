package com.davi.shop.dto.auth;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegisterDTO {

    @Size(min = 1, max = 100)
    @NotBlank(message = "'name' cannot be empty.")
    private String name;

    @Size(min = 1, max = 100)
    @NotBlank(message = "'username' cannot be empty.")
    private String username;

    @Size(min = 1, max = 100)
    @NotBlank(message = "'email' cannot be empty.")
    private String email;

    @Size(min = 1, max = 35)
    @NotBlank(message = "'password' cannot be empty.")
    private String password;

    public RegisterDTO(String name, String username, String email,
	    String password) {
	this.name = name;
	this.username = username;
	this.email = email;
	this.password = password;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }
}