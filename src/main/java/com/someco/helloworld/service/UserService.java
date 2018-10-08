package com.someco.helloworld.service;

import java.util.List;

import com.someco.helloworld.model.User;



public interface UserService {
	
	public void saveUser(User user) ;
	
	public void updateUser(User user);
	
	public String deleteUser(String userName);
	
	public User findByUserName(String userName);
	
	User findById(int id);
	
	 List<User> findAll();

}
