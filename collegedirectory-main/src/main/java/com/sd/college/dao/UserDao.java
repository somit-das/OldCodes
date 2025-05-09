package com.sd.college.dao;

import java.util.List;
import java.util.Optional;

import com.sd.college.entity.User;


public interface UserDao {

	Optional<User> findByUsernameAndPassword(String username, String password);

	User saveUser(User user);

	List<User> findAllUsers();

	Optional<User> findUserById(int id);

	Optional<User> findUserByEmail(String email);

}
