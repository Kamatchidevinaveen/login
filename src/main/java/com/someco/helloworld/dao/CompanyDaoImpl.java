package com.someco.helloworld.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.someco.helloworld.model.Company;

@Repository("companyDao")
@Transactional
public class CompanyDaoImpl extends AbstractDao<Integer, Company> implements CompanyDao{
	
	public void saveCompany(Company company)  {
		persist(company);
		//throw new Exception("some exception");
	}
	
	public String deleteCompany(String companyName) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("companyName", companyName));
		Company company = (Company) criteria.uniqueResult();
		delete(company);
		return "Deleted Successfully" ;
	
	}
	
	@SuppressWarnings("unchecked")
	public List<Company> findAll() {
		Criteria crit = createEntityCriteria();
        return (List<Company>) crit.list();
	}
	
	public Company findByCompany(String companyName) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("companyName", companyName));
		return (Company) crit.uniqueResult();
	}
	

}
