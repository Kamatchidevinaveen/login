package com.someco.helloworld.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.someco.helloworld.dao.UserDao;
import com.someco.helloworld.model.User;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	public User findById(int id) {
		return userDao.findById(id);
	}

	
	public void saveUser(User user)  {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userDao.saveUser(user);
	}

	public void updateUser(User user) {
		// do not use this, not completed
		//user.setPassword(passwordEncoder.encode(user.getPassword()));
		userDao.updateUser(user);
	}

	public String deleteUser(String userName) {
		return userDao.deleteUser(userName);
	}

	public User findByUserName(String userName) {
		return userDao.findByUserName(userName);
	}
	
	public List<User> findAll() {
		return userDao.findAll();
	}

}
