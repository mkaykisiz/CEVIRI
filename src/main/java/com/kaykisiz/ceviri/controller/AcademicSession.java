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

import com.kaykisiz.ceviri.model.Academic;

@ManagedBean(name="AcademicSession")
@SessionScoped
public class AcademicSession implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;
	
	private Academic academic;
	
	private List<Academic> academics;

	private String pass;
	
	private String mail;
	
	public String login(){
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Academic> criteriaQuery = criteriaBuilder
				.createQuery(Academic.class);
		Root<Academic> acm = criteriaQuery.from(Academic.class);
		criteriaQuery.where(criteriaBuilder.equal(acm.get("mail"), mail));
		academics = entityManager.createQuery(criteriaQuery).getResultList();
		
		if(!academics.isEmpty() && academics.get(0).getMail().equals(mail) && academics.get(0).getParola().equals(pass)){
		academic=academics.get(0);
		System.out.println(academic.getName());
		}
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

	public Academic getAcademic() {
		return academic;
	}

	public void setAcademic(Academic academic) {
		this.academic = academic;
	}
	
	
	
	
	
}
