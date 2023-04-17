package com.davi.shop.utils;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.davi.shop.exceptions.ShopAPIException;

public class PasswordUtils {

    private static PasswordEncoder passwordEncoder;

    private PasswordUtils(final PasswordEncoder passwordEncoder) {
	PasswordUtils.passwordEncoder = passwordEncoder;
    }

    public static String hashPassword(String unhashedPassword) {
	if (!unhashedPassword.isBlank()) {
	    return passwordEncoder.encode(unhashedPassword);
	} else {
	    throw new ShopAPIException(
		    HttpStatus.UNPROCESSABLE_ENTITY,
		    "please use a valid password.");
	}
    }

    public static boolean decodePassword(String rawPassword,
	    String encodedPassword) {
	if (!encodedPassword.isBlank() && !rawPassword.isBlank()) {
	    return passwordEncoder.matches(rawPassword,
		    encodedPassword);
	} else {
	    throw new ShopAPIException(
		    HttpStatus.UNPROCESSABLE_ENTITY,
		    "please use a valid password.");
	}
    }

}
