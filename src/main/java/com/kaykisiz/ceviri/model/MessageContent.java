package com.kaykisiz.ceviri.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Entity implementation class for Entity: MessageContent
 *
 */
@Entity

public class MessageContent implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public MessageContent() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
   
	@ManyToOne
	private Message message;
	
	private boolean read;
	
	@Column(length=600)
	@Size(max=600,message="Max. 600 karakter !")
	private String text;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public boolean isRead() {
		return read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
}
