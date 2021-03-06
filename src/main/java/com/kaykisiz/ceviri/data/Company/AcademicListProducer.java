package com.kaykisiz.ceviri.data.Company;

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

import com.kaykisiz.ceviri.model.Academic;


//Ünvan Listesini getirir.

@RequestScoped
public class AcademicListProducer {
	
	@Inject
	private EntityManager entityManager;

	private List<Academic> academics;

	@Produces
	@Named
	public List<Academic> getAcademicsCompany() {
		return academics;
	} 

	public void onTitleListChanged(
			@Observes(notifyObserver = Reception.IF_EXISTS) final Academic companies) {
		retrieveAllCompanies();
	}

	@PostConstruct
	public void retrieveAllCompanies() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Academic> criteriaQuery = criteriaBuilder
				.createQuery(Academic.class);
		Root<Academic> comp = criteriaQuery.from(Academic.class);
		criteriaQuery.select(comp);
		academics = entityManager.createQuery(criteriaQuery).getResultList();
	}
}
