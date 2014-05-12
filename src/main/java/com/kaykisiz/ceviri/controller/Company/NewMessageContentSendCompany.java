package com.kaykisiz.ceviri.controller.Company;

import java.io.Serializable;

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

import com.kaykisiz.ceviri.model.MessageContent;

@Stateful
@Model
public class NewMessageContentSendCompany implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;

	@Inject
	private FacesContext facesContext;

	@Inject
	private Event<MessageContent> messageContentEvent;
	
	@Inject
	private CompanySession companySession;

	private MessageContent messageContent;

	@Named
	@Produces
	public MessageContent getMessageContentCompany() {
		return messageContent;
	}


	public String newMessageContent() {
	messageContent.setMessage(companySession.getSelectedMessage());
	messageContent.setRead(false);
		try {
			entityManager.persist(messageContent);
			messageContentEvent.fire(messageContent);
			
			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO,
					"Firma kaydı başarıyla yapıldı.","Firma kaydı başarıyla yapıldı."));

			initnewmessage();

		} catch (Exception e) {
			e.printStackTrace();
			
			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Firma kaydedilemedi!",
					"Firma kaydedilemedi!"));
		}
return"MessageContent";
	}

	

	@PostConstruct
	public void initnewmessage() {
		messageContent = new MessageContent();
	}

}
