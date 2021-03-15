package com.tr.task.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tr.task.dto.LoggedInUserDto;
import com.tr.task.dto.UserDto;
import com.tr.task.entity.User;
import com.tr.task.repository.UserRepository;
import com.tr.task.service.UserService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService,UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private  PasswordEncoder passwordEncoder;

	@Override
	public LoggedInUserDto loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = this.userRepository.findByUserName(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with username:" + username));

		return new LoggedInUserDto(user);
	}
	

	@Override
	public UserDto save(UserDto user) {
		User userEntity=new User();
		userEntity.setFullName(user.getFullName());
		userEntity.setEmail(user.getEmail());
		userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
		userEntity.setUserName(user.getUserName());
		
		userEntity=this.userRepository.save(userEntity);
		
		user.setId(userEntity.getId());
		return user;
	}

}
