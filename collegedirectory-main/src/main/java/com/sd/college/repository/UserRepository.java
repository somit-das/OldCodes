package com.sd.college.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sd.college.entity.User;


public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByUsernameAndPassword(String username, String password);

	Optional<User> findByEmail(String email);
}
