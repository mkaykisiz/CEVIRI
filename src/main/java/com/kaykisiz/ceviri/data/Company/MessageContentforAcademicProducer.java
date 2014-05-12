package com.kaykisiz.ceviri.data.Company;

import java.io.Serializable;
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

import com.kaykisiz.ceviri.controller.Company.CompanySession;
import com.kaykisiz.ceviri.model.MessageContent;

@RequestScoped
public class MessageContentforAcademicProducer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private EntityManager entityManager;

	private List<MessageContent> messageContents;

	@Inject
	private CompanySession companySession;

	@Named
	@Produces
	public List<MessageContent> getmessageContentsCompany() {
		return messageContents;
	}

	public void onStudentListChanged(
			@Observes(notifyObserver = Reception.IF_EXISTS) final MessageContent messageContents) {
		retrieveAllMessageContentsCompany();
	}

	@PostConstruct
	public void retrieveAllMessageContentsCompany() {

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<MessageContent> criteriaQuery = criteriaBuilder
				.createQuery(MessageContent.class);
		Root<MessageContent> msgc = criteriaQuery.from(MessageContent.class);
		criteriaQuery.where(criteriaBuilder.equal(msgc.get("message"),
				companySession.getSelectedMessage()));
		messageContents = entityManager.createQuery(criteriaQuery)
				.getResultList();
	}
}

