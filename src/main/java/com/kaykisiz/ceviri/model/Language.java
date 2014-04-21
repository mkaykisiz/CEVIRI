package com.kaykisiz.ceviri.model;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Language
 *
 */
@Entity

public class Language implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Language() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	
	@Column(length=180)
	private String language;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getUrl() {
		return language;
	}

	public void setUrl(String url) {
		this.language = url;
	}
	
}
