package com.kaykisiz.ceviri.controller.Company;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import com.kaykisiz.ceviri.model.Message;

@Model
@Stateful
public class NewMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;

	@Inject
	private Event<Message> messageEvent;
	
	private Message message;
	
	@Inject
	private CompanySession companySession;
	
	
	@Named("NewMessage")
	@Produces
	public Message getNewMessage() {
		return message;
	}

	public String NewMessageCreate(){
		message.setTitle("Başlık");
		message.setAcademic(companySession.getSelectedAcademic());
		message.setCompany(companySession.getCompany());
		entityManager.persist(message);
		messageEvent.fire(message);
		initTranslation();
		return "/Company/Messages/index.xhtml?faces-redirect=true";
	}
	
	@PostConstruct
	public void initTranslation() {
		message = new Message();

	}



	
	

}
