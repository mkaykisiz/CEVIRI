package com.kaykisiz.ceviri.controller.Student;

	import java.io.Serializable;
import java.util.List;

	import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.kaykisiz.ceviri.model.Student;
import com.kaykisiz.ceviri.model.Translation;

	@ManagedBean(name="StudentSession")
	@SessionScoped
	public class StudentSession implements Serializable{

		private static final long serialVersionUID = 1L;

		@Inject
		private EntityManager entityManager;
		
		private Student student;
		
		private List<Student> students;
		
		private Translation selectedTranslation;

		private String pass;
		
		private String mail;
		
		public String login(){
			
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Student> criteriaQuery = criteriaBuilder
					.createQuery(Student.class);
			Root<Student> st = criteriaQuery.from(Student.class);
			criteriaQuery.where(criteriaBuilder.equal(st.get("mail"), mail));
			students = entityManager.createQuery(criteriaQuery).getResultList();
			
			if(!students.isEmpty() && students.get(0).getMail().equals(mail) && students.get(0).getParola().equals(pass))
				student=students.get(0);
			
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

		public Student getStudent() {
			return student;
		}

		public void setStudent(Student student) {
			this.student = student;
		}

		public Translation getSelectedTranslation() {
			return selectedTranslation;
		}

		public void setSelectedTranslation(Translation selectedTranslation) {
			this.selectedTranslation = selectedTranslation;
		}
		
		
		
		
		
	}
