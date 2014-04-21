package com.kaykisiz.ceviri.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: CoverImage
 *
 */
@Entity

public class CoverImage implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public CoverImage() {
		super();
	}
   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	
	@Column(length=180)
	private String url;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
