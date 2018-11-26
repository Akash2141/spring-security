package com.spring.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.security.entity.user;
import com.spring.security.repository.userRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	userRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		user user=userRepo.findByUsername(username);
		
		if(user==null)
			throw new BadCredentialsException("user Not Found");
		
		new AccountStatusUserDetailsChecker().check(user);
		
		return user;
	}

	
}
