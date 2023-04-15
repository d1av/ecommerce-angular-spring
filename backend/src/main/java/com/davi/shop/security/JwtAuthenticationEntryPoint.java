package com.davi.shop.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationEntryPoint
	implements AuthenticationEntryPoint {

    @Autowired
    @Qualifier("handlerExceptionResolver")
    private HandlerExceptionResolver resolver;

    @Override
    public void commence(HttpServletRequest request,
	    HttpServletResponse response,
	    AuthenticationException authException)
	    throws IOException, ServletException {

	resolver.resolveException(request, response, null,
		authException);
//	
//	ShopAPIException re = new ShopAPIException(
//		HttpStatus.UNAUTHORIZED, "Authentication failed");
//	response.setContentType(MediaType.APPLICATION_JSON_VALUE);
//	response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//	response.getOutputStream();
//	OutputStream responseStream = response.getOutputStream();
//	ObjectMapper mapper = new ObjectMapper();
//	mapper.writeValue(responseStream, re);
//	responseStream.flush();
    }
}