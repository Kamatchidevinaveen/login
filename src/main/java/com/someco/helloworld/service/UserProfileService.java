package com.someco.helloworld.service;

import java.util.List;

import com.someco.helloworld.model.UserProfile;
import com.someco.helloworld.model.UserProfileType;

public interface UserProfileService {

	UserProfile findById(int id);
	 
    UserProfile findByType(UserProfileType type);
     
    List<UserProfile> findAll();
    
}
