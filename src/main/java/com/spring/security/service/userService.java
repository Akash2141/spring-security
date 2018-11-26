package com.spring.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.security.entity.user;
import com.spring.security.repository.userRepository;

@Service
public class userService {
	
	@Autowired
	userRepository userRepo;
	
	public void saveUser(user user) {
		userRepo.save(user);
	}
	
	public List<user> allUsers() {
		List<user> users=new ArrayList<user>();
		userRepo.findAll().forEach(users::add);
		return users;
	}

}
