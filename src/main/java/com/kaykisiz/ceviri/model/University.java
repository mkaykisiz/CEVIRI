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
	private short UniversityId;
	
	@Column(length=70)
	private String universityName;

	public short getUniversityId() {
		return UniversityId;
	}

	public void setUniversityId(short universityId) {
		UniversityId = universityId;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
	
	
}