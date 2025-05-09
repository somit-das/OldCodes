package com.sd.college.service;

import org.springframework.http.ResponseEntity;

import com.sd.college.entity.User;
import com.sd.college.util.AuthUser;


public interface UserService {

	ResponseEntity<?> findByUsernameAndPassword(AuthUser authUser);

	ResponseEntity<?> saveUser(User user);

	ResponseEntity<?> findAllUsers();

	ResponseEntity<?> findUserById(int id);

	ResponseEntity<String> verifyOtp(String otp, String email);
}
