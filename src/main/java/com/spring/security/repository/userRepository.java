package com.spring.security.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.security.entity.user;

@Repository
@Transactional
public interface userRepository extends JpaRepository<user, Long>{
	user findByUsername(String username);
}
