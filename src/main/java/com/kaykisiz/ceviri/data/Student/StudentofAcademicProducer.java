package com.kaykisiz.ceviri.data.Student;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.kaykisiz.ceviri.controller.Student.StudentSession;
import com.kaykisiz.ceviri.model.Academic;

//Acedemic ve student entityleri ile strudent entitysi arası ilşkiyi sağlar

@RequestScoped
public class StudentofAcademicProducer  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;

	private List<Academic> academics;

	
	
	
	@Named
	@Produces
	public List<Academic> getStudentAcademic() {
		return academics;
	} 

	

	public void onStudentAcademicListChanged(
			@Observes(notifyObserver = Reception.IF_EXISTS) final Academic academics) {
		retrieveAllStudentAcademics();
	}

	@PostConstruct
	public void retrieveAllStudentAcademics() {
	
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Academic> criteriaQuery = criteriaBuilder
				.createQuery(Academic.class);
		Root<Academic> acm = criteriaQuery.from(Academic.class);
		criteriaQuery.select(acm);
		academics = entityManager.createQuery(criteriaQuery).getResultList();
		
	}
}
