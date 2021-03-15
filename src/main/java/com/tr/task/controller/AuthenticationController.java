package com.tr.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tr.task.dto.LoggedInUserDto;
import com.tr.task.security.JwtTokenProvider;

@RestController
@RequestMapping(value = "/api/v1/auth")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenProvider jwtProvider;

	@Autowired
	private UserDetailsService userDetailsService;

	@PostMapping(value = "/signIn")
	public LoggedInUserDto createAuthenticationToken(@RequestBody LoggedInUserDto loggedInUserDto) {

		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				loggedInUserDto.getUsername(), loggedInUserDto.getPassword());

		Authentication authentication;

		try {
			authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
		} catch (BadCredentialsException e) {
			throw new BadCredentialsException("error.username.in-correct", e);
		}
	
		UserDetails user = this.userDetailsService.loadUserByUsername(loggedInUserDto.getUsername());

		String token = jwtProvider.generateToken(user);

		loggedInUserDto.setToken(token);

		return loggedInUserDto;
	}
	
//	@PostMapping(value = "/signOut")
//	public LoggedInUserDto removeAuthenticationToken(@RequestBody LoggedInUserDto loggedInUserDto) {
//
//	        
//
//		return null;
//	}


}
