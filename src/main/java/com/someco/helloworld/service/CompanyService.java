package com.someco.helloworld.service;

import java.util.List;

import com.someco.helloworld.model.Company;

public interface CompanyService {
	
	public void saveCompany(Company company) ;
	
	public String deleteCompany(String companyName);
	
	List<Company> findAll();
	
	public Company findByCompany(String companyName);

}
