package com.kaykisiz.ceviri.data.Academic;

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

import com.kaykisiz.ceviri.model.University;

//Üniversitelerin Listesini getirir.

@RequestScoped
public class UniversityListProducer {

	@Inject
	private EntityManager entityManager;

	private List<University> universities;

	@Produces
	@Named
	public List<University> getUniversities() {
		return universities;
	}

	public void onUniverstiyListChanged(
			@Observes(notifyObserver = Reception.IF_EXISTS) final University universities) {
		retrieveAllUniversities();
	}

	@PostConstruct
	public void retrieveAllUniversities() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<University> criteriaQuery = criteriaBuilder
				.createQuery(University.class);
		Root<University> university = criteriaQuery.from(University.class);
		criteriaQuery.select(university);
		universities = entityManager.createQuery(criteriaQuery).getResultList();
	}
}
