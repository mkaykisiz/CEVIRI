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

import com.kaykisiz.ceviri.model.Academic;

@Stateful
@Model
public class AcademicRegister {

	@Inject
	private EntityManager entityManager;

	@Inject
	private FacesContext facesContext;

	@Inject
	private Event<Academic> academicEvent;

	private Academic academic;

	@Named
	@Produces
	public Academic getAcademic() {
		return academic;
	}

	public void registerAcademic() {

		try {
			entityManager.persist(academic);
			academicEvent.fire(academic);
			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO,
					"Bölüm kaydı başarıyla yapıldı.", " "));
			initAcademic();
		} catch (Exception e) {
			e.printStackTrace();

			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Bölüm kaydedilemedi!",
					"Bölüm kaydedilemedi!"));
		}

	}

	@PostConstruct
	public void initAcademic() {
		academic = new Academic();
	}

	
	
	

}
