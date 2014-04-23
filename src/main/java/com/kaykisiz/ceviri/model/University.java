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
	private short UniversityID;
	
	@Column(length=70)
	private String universityName;

	public short getUniversityID() {
		return UniversityID;
	}

	public void setUniversityID(short universityID) {
		UniversityID = universityID;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
	
	
}