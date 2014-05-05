package com.kaykisiz.ceviri.controller;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import com.kaykisiz.ceviri.data.UniversityListProducer;
import com.kaykisiz.ceviri.model.University;
import com.kaykisiz.ceviri.model.University;

@Stateful
@Model
public class UniversityRegister {

	@Inject
	private EntityManager entityManager;

	@Inject
	private Event<University> academicEvent;

	private University university;

	

	@Named
	@Produces
	public University getUniversity() {
		return university;
	}

	

	public void registerAcademic() {

		
			entityManager.persist(university);
			academicEvent.fire(university);
			initUniversity();
		

	}

	@PostConstruct
	public void initUniversity() {
		university = new University();
	}

}
