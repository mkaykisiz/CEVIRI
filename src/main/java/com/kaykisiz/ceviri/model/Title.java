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
	private int titleId;
	
	@Column(length=20)
	private String title;
	

	public int getTitleId() {
		return titleId;
	}

	public void setTitleId(int titleId) {
		this.titleId = titleId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	
}