package com.kaykisiz.ceviri.controller.Academic;

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
import com.kaykisiz.ceviri.model.Company;
import com.kaykisiz.ceviri.model.Message;
import com.kaykisiz.ceviri.model.Student;
import com.kaykisiz.ceviri.model.Translation;

@ManagedBean(name="AcademicSession")
@SessionScoped
public class AcademicSession implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;

	private static Academic academic;
	
	private List<Academic> academics;

	private String pass;
	
	private String mail;
	
	private  Student selectedStudent;
	
	private Company selectedCompany;
	
	private  Message selectedMessage;
	
	private Translation selectedTranslation;
	
	public String studentProfileShow(){
		return "Academic/Profile/StudentPage.xhtml" ;
	}
	
	public String companyProfile(){
		return "Academic/Company/CompanyPage.xhtml";
	}
	
	public String MessageContents(){
		return "/MessageContent.xhtml";
	}
	
	public String login(){
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Academic> criteriaQuery = criteriaBuilder
				.createQuery(Academic.class);
		Root<Academic> acm = criteriaQuery.from(Academic.class);
		criteriaQuery.where(criteriaBuilder.equal(acm.get("mail"), mail));
		academics = entityManager.createQuery(criteriaQuery).getResultList();
		
		if(!academics.isEmpty() && academics.get(0).getMail().equals(mail) && academics.get(0).getParola().equals(pass)){
		academic=academics.get(0);

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
		AcademicSession.academic = academic;
	}

	public Student getSelectedStudent() {
		return selectedStudent;
	}

	public void setSelectedStudent(Student selectedStudent) {
		this.selectedStudent = selectedStudent;
	}

	public Company getSelectedCompany() {
		return selectedCompany;
	}

	public void setSelectedCompany(Company selectedCompany) {
		this.selectedCompany = selectedCompany;
	}

	public Message getSelectedMessage() {
		return selectedMessage;
	}

	public void setSelectedMessage(Message selectedMessage) {
		this.selectedMessage = selectedMessage;
	}

	public Translation getSelectedTranslation() {
		return selectedTranslation;
	}

	public void setSelectedTranslation(Translation selectedTranslation) {
		this.selectedTranslation = selectedTranslation;
	}


	
	
	
	
	
}
