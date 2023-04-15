package com.davi.shop.security;

import java.io.IOException;
import java.io.OutputStream;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.davi.shop.exceptions.ShopAPIException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationEntryPoint
	implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request,
	    HttpServletResponse response,
	    AuthenticationException authException)
	    throws IOException, ServletException {
	ShopAPIException re = new ShopAPIException(
		HttpStatus.UNAUTHORIZED, "Authentication failed");
	response.setContentType(MediaType.APPLICATION_JSON_VALUE);
	response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	response.getOutputStream();
	OutputStream responseStream = response.getOutputStream();
	ObjectMapper mapper = new ObjectMapper();
	mapper.writeValue(responseStream, re);
	responseStream.flush();
    }
}