package com.sd.college.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sd.college.entity.User;
import com.sd.college.service.UserService;
import com.sd.college.util.AuthUser;
import com.sd.college.util.OtpVerificationRequest;


//@CrossOrigin
@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	UserService service;

	@PostMapping(value = "/login")
	public ResponseEntity<?> findByUsernameAndPassword(@RequestBody AuthUser authUser) {
		return service.findByUsernameAndPassword(authUser);
	}

	@PostMapping
	public ResponseEntity<?> saveUser(@RequestBody User user) {
		return service.saveUser(user);
	}

	@PostMapping("/verify-otp")
	public ResponseEntity<String> verifyOtp(@RequestBody OtpVerificationRequest otprequest) {
		return service.verifyOtp(otprequest.getOtp(),otprequest.getEmail());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findUserById(@PathVariable int id) {
		return service.findUserById(id);
	}

	@GetMapping
	public ResponseEntity<?> findAllUsers() {
		return service.findAllUsers();
	}

}
