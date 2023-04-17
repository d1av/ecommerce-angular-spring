package com.davi.shop.dto.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegisterDTO {

    @Size(min = 1, max = 100, message = "The Name must have beetwen 1 and 100 letters.")
    @NotBlank(message = "'firstName' cannot be empty.")
    private String firstName;

    @Size(min = 1, max = 100, message = "The Name must have beetwen 1 and 100 letters.")
    @NotBlank(message = "'lastName' cannot be empty.")
    private String lastName;

    @Size(min = 1, max = 100)
    @NotBlank(message = "'username' cannot be empty.")
    private String username;

    @Size(min = 1, max = 100)
    @NotBlank(message = "'email' cannot be empty.")
    private String email;

    @Size(min = 1, max = 35)
    @NotBlank(message = "'password' cannot be empty.")
    private String password;

    private RegisterDTO(
	    @Size(min = 1, max = 100, message = "The Name must have beetwen 1 and 100 letters.") @NotBlank(message = "'firstName' cannot be empty.") String firstName,
	    @Size(min = 1, max = 100, message = "The Name must have beetwen 1 and 100 letters.") @NotBlank(message = "'lastName' cannot be empty.") String lastName,
	    @Size(min = 1, max = 100) @NotBlank(message = "'username' cannot be empty.") String username,
	    @Size(min = 1, max = 100) @NotBlank(message = "'email' cannot be empty.") String email,
	    @Size(min = 1, max = 35) @NotBlank(message = "'password' cannot be empty.") String password) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.username = username;
	this.email = email;
	this.password = password;
    }

    public static RegisterDTO with(String firstName, String lastName,
	    String username, String email, String password) {
	return new RegisterDTO(firstName, lastName, username, email,
		password);
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

    public String getPassword() {
	return password;
    }

}