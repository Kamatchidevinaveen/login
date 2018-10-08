package com.someco.helloworld.dao;

import org.springframework.stereotype.Repository;

import com.someco.helloworld.dao.UserDocumentDao;
import com.someco.helloworld.model.UserDocuments;

@Repository("userDocumentDao")
public class UserDocumentDaoImpl extends AbstractDao<Integer, UserDocuments> implements UserDocumentDao {

	@Override
	public void saveUserDocument(UserDocuments userDocuments) {
		/*UserDocuments userDocuments = new UserDocuments();
		userDocuments.setDocumentName(documentName);
		userDocuments.setDocumentMimetype(mimeype);
		userDocuments.setDocumentData(documentData);*/
		persist(userDocuments);
	}

}
