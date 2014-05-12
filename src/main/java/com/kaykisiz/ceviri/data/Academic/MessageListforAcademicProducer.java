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

import com.kaykisiz.ceviri.controller.Academic.AcademicSession;
import com.kaykisiz.ceviri.model.Message;

//Ünvan Listesini getirir.

@RequestScoped
public class MessageListforAcademicProducer {
	
	@Inject
	private EntityManager entityManager;
	
	@Inject
	private AcademicSession academicSession;

	private List<Message> messages;

	@Produces
	@Named
	public List<Message> getAcedemicMessages() {
		return messages;
	} 

	public void onTitleListChanged(
			@Observes(notifyObserver = Reception.IF_EXISTS) final Message messages) {
		retrieveAllCompanies();
	}

	@PostConstruct
	public void retrieveAllCompanies() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Message> criteriaQuery = criteriaBuilder
				.createQuery(Message.class);
		Root<Message> msg = criteriaQuery.from(Message.class);
		criteriaQuery.where(criteriaBuilder.equal(msg.get("academic"), academicSession.getAcademic()));
		messages = entityManager.createQuery(criteriaQuery).getResultList();
	}
}
