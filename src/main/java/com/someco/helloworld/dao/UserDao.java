package com.someco.helloworld.dao;

import java.util.List;

import com.someco.helloworld.model.User;

public interface UserDao {
	
	public void saveUser(User user) ;
	
	public String deleteUser(String userName);
	
	public void updateUser(User user);

	public User findByUserName(String userName);
    
	User findById(int id);
	
	List<User> findAll();
}
