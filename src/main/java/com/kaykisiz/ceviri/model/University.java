package com.kaykisiz.ceviri.model;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: University
 *
 */
@Entity
public class University implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	public University() {
		super();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int UniversityId;
	
	@Column(length=70)
	private String universityName;

	public int getUniversityId() {
		return UniversityId;
	}

	public void setUniversityId(int universityId) {
		UniversityId = universityId;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
	
	
}