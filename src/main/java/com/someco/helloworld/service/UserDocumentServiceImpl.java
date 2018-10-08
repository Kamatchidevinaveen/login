package com.someco.helloworld.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.someco.helloworld.dao.UserDocumentDao;
import com.someco.helloworld.model.UserDocuments;

@Service("userDocumentService")
@Transactional
public class UserDocumentServiceImpl  implements UserDocumentService {
	
	@Autowired
	UserDocumentDao userDocumentDao;
	
	@Override
	public void saveUserDocument(UserDocuments userDocuments) {
		userDocumentDao.saveUserDocument(userDocuments);
	}

}
