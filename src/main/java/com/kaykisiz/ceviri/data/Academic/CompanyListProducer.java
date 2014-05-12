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

import com.kaykisiz.ceviri.model.Company;

//Ünvan Listesini getirir.

@RequestScoped
public class CompanyListProducer {
	
	@Inject
	private EntityManager entityManager;

	private List<Company> companies;

	@Produces
	@Named
	public List<Company> getcompanies() {
		return companies;
	} 

	public void onTitleListChanged(
			@Observes(notifyObserver = Reception.IF_EXISTS) final Company companies) {
		retrieveAllCompanies();
	}

	@PostConstruct
	public void retrieveAllCompanies() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Company> criteriaQuery = criteriaBuilder
				.createQuery(Company.class);
		Root<Company> comp = criteriaQuery.from(Company.class);
		criteriaQuery.select(comp);
		companies = entityManager.createQuery(criteriaQuery).getResultList();
	}
}
