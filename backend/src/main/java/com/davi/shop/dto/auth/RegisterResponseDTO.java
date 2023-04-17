package com.davi.shop.dto.auth;

import com.davi.shop.entities.User;

public class RegisterResponseDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String status;

    private RegisterResponseDTO(Long id, String firstName,
	    String lastName, String username, String email) {
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.username = username;
	this.email = email;
	this.status = "User Created";
    }

    public static RegisterResponseDTO with(Long id, String firstName,
	    String lastName, String username, String email) {
	return new RegisterResponseDTO(id, firstName, lastName,
		username, email);
    }

    public static RegisterResponseDTO from(User user) {
	return new RegisterResponseDTO(user.getId(),
		user.getFirstName(), user.getLastName(),
		user.getUsername(), user.getEmail());
    }

    public String getStatus() {
	return status;
    }

    public Long getId() {
	return id;
    }

    public String getFirstName() {
	return firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public String getUsername() {
	return username;
    }

    public String getEmail() {
	return email;
    }

}
