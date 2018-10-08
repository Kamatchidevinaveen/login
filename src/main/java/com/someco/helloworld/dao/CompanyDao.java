package com.someco.helloworld.dao;


import java.util.List;

import com.someco.helloworld.model.Company;

public interface CompanyDao {
	
	public void saveCompany(Company company) ;
	
	public String deleteCompany(String companyName);
	
	List<Company> findAll();
	
	public Company findByCompany(String companyName);


}
