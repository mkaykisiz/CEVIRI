package com.kaykisiz.ceviri.data;

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

import com.kaykisiz.ceviri.controller.AcademicSession;
import com.kaykisiz.ceviri.model.MessageContent;

//Ünvan Listesini getirir.

@RequestScoped

public class MessageContentProducer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;

	private List<MessageContent> messageContents;

	@Inject
	private AcademicSession academicSession;
	
	@Produces
	@Named
	public List<MessageContent> getMessageContents() {
		return messageContents;
	} 



	public void onStudentListChanged(
			@Observes(notifyObserver = Reception.IF_EXISTS) final MessageContent messageContents) {
		retrieveAllStudents();
	}

	@PostConstruct
	public void retrieveAllStudents() {
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<MessageContent> criteriaQuery = criteriaBuilder
				.createQuery(MessageContent.class);
		Root<MessageContent> msgc = criteriaQuery.from(MessageContent.class);
		criteriaQuery.where(criteriaBuilder.equal(msgc.get("message"), academicSession.getSelectedMessageContent().getMessage()));
		messageContents = entityManager.createQuery(criteriaQuery).getResultList();
		System.out.println("asadad");
	}
}

