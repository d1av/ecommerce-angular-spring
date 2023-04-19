package com.davi.shop.services.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.davi.shop.config.security.JwtTokenProvider;
import com.davi.shop.dto.controller.auth.LoginDTO;
import com.davi.shop.dto.controller.auth.RegisterDTO;
import com.davi.shop.dto.service.LoginRolesResponseDTO;
import com.davi.shop.entities.role.Role;
import com.davi.shop.entities.user.User;
import com.davi.shop.exceptions.DataNotFoundException;
import com.davi.shop.exceptions.ShopAPIException;
import com.davi.shop.repositories.RoleRepository;
import com.davi.shop.repositories.UserRepository;
import com.davi.shop.services.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private JwtTokenProvider jwtTokenProvider;

    public AuthServiceImpl(
	    AuthenticationManager authenticationManager,
	    UserRepository userRepository,
	    RoleRepository roleRepository,
	    PasswordEncoder passwordEncoder,
	    JwtTokenProvider jwtTokenProvider) {
	this.authenticationManager = authenticationManager;
	this.userRepository = userRepository;
	this.roleRepository = roleRepository;
	this.passwordEncoder = passwordEncoder;
	this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public LoginRolesResponseDTO login(LoginDTO loginDto) {
	Authentication authentication = authenticationManager
		.authenticate(new UsernamePasswordAuthenticationToken(
			loginDto.getUsernameOrEmail(),
			loginDto.getPassword()));

	SecurityContextHolder.getContext()
		.setAuthentication(authentication);

	List<String> roles = SecurityContextHolder.getContext()
		.getAuthentication().getAuthorities().stream()
		.map(GrantedAuthority::getAuthority).toList();

	return LoginRolesResponseDTO.with(
		jwtTokenProvider.generateToken(authentication),
		roles);
    }

    @Override
    public User register(RegisterDTO registerDto) {

	// add check for username exists in database
	if (Boolean.TRUE.equals(userRepository
		.existsByUsername(registerDto.getUsername()))) {
	    throw new ShopAPIException(HttpStatus.BAD_REQUEST,
		    "Username is already exists!.");
	}

	// add check for email exists in database
	if (Boolean.TRUE.equals(userRepository
		.existsByEmail(registerDto.getEmail()))) {
	    throw new ShopAPIException(HttpStatus.BAD_REQUEST,
		    "Email is already exists!.");
	}

	User user = User.newCustomerUser(registerDto.getFirstName(),
		registerDto.getLastName(), registerDto.getUsername(),
		registerDto.getEmail(),
		passwordEncoder.encode(registerDto.getPassword()));
	User savedUser = userRepository.saveAndFlush(user);

	Set<Role> roles = new HashSet<>();
	Role userRole = roleRepository.findByName("ROLE_CUSTOMER")
		.orElseThrow(() -> new DataNotFoundException(
			"role for member not found, please contact and admin."));
	roles.add(userRole);
	savedUser.setRoles(roles);

	return userRepository.save(savedUser);

    }
}
