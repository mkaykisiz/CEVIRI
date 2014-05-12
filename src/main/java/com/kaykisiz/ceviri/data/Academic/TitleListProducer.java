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

import com.kaykisiz.ceviri.model.Title;

//Ünvan Listesini getirir.

@RequestScoped
public class TitleListProducer {

	@Inject
	private EntityManager entityManager;

	private List<Title> titles;

	@Produces
	@Named
	public List<Title> getTitles() {
		return titles;
	} 

	public void onTitleListChanged(
			@Observes(notifyObserver = Reception.IF_EXISTS) final Title titles) {
		retrieveAllTitles();
	}

	@PostConstruct
	public void retrieveAllTitles() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Title> criteriaQuery = criteriaBuilder
				.createQuery(Title.class);
		Root<Title> titl = criteriaQuery.from(Title.class);
		criteriaQuery.select(titl);
		titles = entityManager.createQuery(criteriaQuery).getResultList();
	}
}
