package com.kaykisiz.ceviri.model;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Title
 *
 */
@Entity

public class Title implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Title() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	
	@Column(length=180)
	private String title;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getUrl() {
		return title;
	}

	public void setUrl(String title) {
		this.title = title;
	}
   
}
