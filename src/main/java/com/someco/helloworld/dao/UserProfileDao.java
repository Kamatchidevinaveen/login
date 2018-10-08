package com.someco.helloworld.dao;

import java.util.List;

import com.someco.helloworld.model.UserProfile;
import com.someco.helloworld.model.UserProfileType;

public interface UserProfileDao {
	
	List<UserProfile> findAll();
	
	UserProfile findByType(UserProfileType type);
	
	UserProfile findById(int id);

}
