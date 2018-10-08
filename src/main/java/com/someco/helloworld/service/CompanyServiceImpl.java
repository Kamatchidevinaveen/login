package com.someco.helloworld.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.someco.helloworld.dao.CompanyDao;
import com.someco.helloworld.model.Company;
import com.someco.helloworld.model.User;

@Service("companyService")
@Transactional
public class CompanyServiceImpl implements CompanyService{
	
	@Autowired
	CompanyDao companyDao;
	
	public void saveCompany(Company company) {  
		companyDao.saveCompany(company);
	}
	
	public String deleteCompany(String companyName) {
		return companyDao.deleteCompany(companyName);
	}
	
	public List<Company> findAll() {
		return companyDao.findAll();
	}
	
	public Company findByCompany(String companyName) {
		return companyDao.findByCompany(companyName);
	}

}
