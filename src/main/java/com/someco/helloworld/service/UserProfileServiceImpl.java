package com.someco.helloworld.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.someco.helloworld.dao.UserProfileDao;
import com.someco.helloworld.model.UserProfile;
import com.someco.helloworld.model.UserProfileType;

@Service("userProfileService")
@Transactional
public class UserProfileServiceImpl implements UserProfileService {

	@Autowired
	UserProfileDao userProfileDao;
	
	public UserProfile findById(int id) {
		return userProfileDao.findById(id);
	}

	public UserProfile findByType(UserProfileType type) {
		return userProfileDao.findByType(type);
	}

	public List<UserProfile> findAll() {
		return userProfileDao.findAll();
	}

}
