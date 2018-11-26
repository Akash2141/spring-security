package com.spring.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

@SpringBootApplication
public class SecurityApplication {
	
	@Autowired
	DataSource dataSource;

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder(5);
	}
	
	@Bean
	public TokenStore tokenStore() {
		
		return new JdbcTokenStore(dataSource);
	}
}
