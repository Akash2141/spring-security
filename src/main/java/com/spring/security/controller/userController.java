package com.spring.security.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.entity.user;
import com.spring.security.service.userService;

@RestController
public class userController {
	
	@Autowired
	userService userService;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@PostMapping("/saveUser")
	@Secured("User")
	public void saveUser(@RequestBody user user) {
		String encPass=encoder.encode(user.getPassword());
		user.setPassword(encPass);
		System.out.println(encPass);
		userService.saveUser(user);
	}
	
	@GetMapping("/allUser")
	public List<user> getAll(){
		return userService.allUsers();
	}
	

}
