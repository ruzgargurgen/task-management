package com.tr.task.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tr.task.dto.UserDto;
import com.tr.task.service.UserService;

@RestController
@RequestMapping(path = "/api/v1/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping(path = "/register")
	public ResponseEntity<UserDto> saveUser(
			@Valid @RequestBody()UserDto user ) {
		return ResponseEntity.ok(this.userService.save(user));
	}
	
	
}
