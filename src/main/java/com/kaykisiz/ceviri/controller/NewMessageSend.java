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

import com.kaykisiz.ceviri.model.MessageContent;

@Stateful
@Model
public class NewMessageSend {
	@Inject
	private EntityManager entityManager;

	@Inject
	private FacesContext facesContext;

	@Inject
	private Event<MessageContent> messageEvent;
	
	private MessageContent messageContent;
	
	@Inject
	private AcademicSession academicSession;


	@Named
	@Produces
	public MessageContent getMessageContent() {
		return messageContent;
	}


	public void setMessageContent(MessageContent messageContent) {
		this.messageContent = messageContent;
	}


	public String newMessage() {
	
		messageContent.setMessage(academicSession.getSelectedMessage());
		
		try {
			
			entityManager.persist(messageContent);
			messageEvent.fire(messageContent);
					
			initMessageContent();
			
		} catch (Exception e) {
			e.printStackTrace();
			
			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Kayıt Başarısız !",
					"Kayıt Başarısız !"));
		}
			return "Academic/Messages/index.xhtml?faces-redirect=true";
		
		

	}

	@PostConstruct
	public void initMessageContent() {
		messageContent = new MessageContent();
	}

}
