package com.kaykisiz.model;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.validator.constraints.Length;

/**
 * Entity implementation class for Entity: University
 *
 */
@Entity
public class University implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private short University_ID;
	
	@Column(length=70)
	private String university_Name;
	
	public short getAdres_ID() {
		return University_ID;
	}

	public void setAdres_ID(short adres_ID) {
		this.University_ID = adres_ID;
	}

	public String getUniversity_Name() {
		return university_Name;
	}

	public void setUniversity_Name(String university_Name) {
		this.university_Name = university_Name;
	}
   
}
