package com.davi.shop.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.davi.shop.config.security.JwtAuthenticationEntryPoint;
import com.davi.shop.config.security.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private JwtAuthenticationEntryPoint authenticationEntryPoint;

    private JwtAuthenticationFilter authenticationFilter;

    public SecurityConfig(
	    JwtAuthenticationEntryPoint authenticationEntryPoint,
	    JwtAuthenticationFilter authenticationFilter) {
	this.authenticationEntryPoint = authenticationEntryPoint;
	this.authenticationFilter = authenticationFilter;
    }

    @Bean
    static PasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationManager authenticationManager(
	    AuthenticationConfiguration configuration)
	    throws Exception {
	return configuration.getAuthenticationManager();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http)
	    throws Exception {

	endpointRolesAndAccess(http);

	http.addFilterBefore(authenticationFilter,
		UsernamePasswordAuthenticationFilter.class);

	return http.build();
    }

    private HttpSecurity endpointRolesAndAccess(HttpSecurity http)
	    throws Exception {
	return http.csrf().disable().cors().and()
		.authorizeHttpRequests().requestMatchers("/h2/**")
		.permitAll()
		.requestMatchers("/api/orders/**")
		.authenticated()
		.requestMatchers("/states/**")
		.permitAll()
		.requestMatchers(HttpMethod.GET, "/products/**")
		.permitAll()
		.requestMatchers("/countries/**")
		.permitAll()
		.requestMatchers(HttpMethod.GET,
			"/product-categories/**")
		.permitAll()
		.requestMatchers("/v3/api-docs/**",
			"/configuration/ui", "/swagger-resources/**",
			"/configuration/security", "/webjars/**",
			"/swagger-ui/**")
		.permitAll()
		.requestMatchers("/checkout/**")
		.permitAll()
		.requestMatchers("/api/auth/**")
		.permitAll()
		.requestMatchers("/**").permitAll()
		.anyRequest().authenticated()
		.and()
		.httpBasic(withDefaults())
		.exceptionHandling(exception -> exception
			.authenticationEntryPoint(
				authenticationEntryPoint))
		.sessionManagement(
			session -> session.sessionCreationPolicy(
				SessionCreationPolicy.STATELESS));
    }
}