package com.someco.helloworld.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="USER_DOCUMENTS")
public class UserDocuments implements Serializable {

	private static final long serialVersionUID = 384783583526997385L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty
	@Column(name="DOCUMENT_NAME", unique=false, nullable=false)
	private String documentName;
	
	@NotEmpty
	@Column(name="DOCUMENT_MIMETYPE", unique=false, nullable=false)
	private String documentMimetype;
	
	@NotEmpty
	@Column(name="DOCUMENT_DATA", unique=false, nullable=true)
	private byte[] documentData;

	//@NotEmpty
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="USER_ID", nullable=false)
	private User user;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public String getDocumentMimetype() {
		return documentMimetype;
	}

	public void setDocumentMimetype(String documentMimetype) {
		this.documentMimetype = documentMimetype;
	}

	public byte[] getDocumentData() {
		return documentData;
	}

	public void setDocumentData(byte[] documentData) {
		this.documentData = documentData;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((documentName == null) ? 0 : documentName.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof UserDocuments))
            return false;
        UserDocuments other = (UserDocuments) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (documentName == null) {
            if (other.documentName != null)
                return false;
        } else if (!documentName.equals(other.documentName))
            return false;
        return true;
	}
}
