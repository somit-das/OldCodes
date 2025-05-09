package com.sd.college.daoimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sd.college.dao.UserDao;
import com.sd.college.entity.User;
import com.sd.college.repository.UserRepository;



@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	UserRepository repository;

	public Optional<User> findByUsernameAndPassword(String username, String password) {
		return repository.findByUsernameAndPassword(username, password);
	}

	@Override
	public User saveUser(User user) {
		return repository.save(user);
	}

	@Override
	public List<User> findAllUsers() {
		return repository.findAll();
	}

	@Override
	public Optional<User> findUserById(int id) {
		return repository.findById(id);
	}

	@Override
	public Optional<User> findUserByEmail(String email) {
//		return repository.findUserByEmail(email);
		return repository.findByEmail(email);
	}

}
