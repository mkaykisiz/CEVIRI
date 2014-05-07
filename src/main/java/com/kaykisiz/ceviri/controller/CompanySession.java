package com.kaykisiz.ceviri.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.kaykisiz.ceviri.model.Company;

@ManagedBean(name="CompanySession")
@SessionScoped
public class CompanySession implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;
	
	private Company company;
	
	private List<Company> companys;

	private String pass;
	
	private String mail;
	
	public String login(){
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Company> criteriaQuery = criteriaBuilder
				.createQuery(Company.class);
		Root<Company> cmp = criteriaQuery.from(Company.class);
		criteriaQuery.where(criteriaBuilder.equal(cmp.get("mail"), mail));
		companys = entityManager.createQuery(criteriaQuery).getResultList();
		
		if(!companys.isEmpty() && companys.get(0).getMail().equals(mail) && companys.get(0).getParola().equals(pass))
		company=companys.get(0);
		
		return "../Profile/index.xhtml";
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
	
	
	
	
}
