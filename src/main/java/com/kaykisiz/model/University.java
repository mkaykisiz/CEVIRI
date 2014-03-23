package com.kaykisiz.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: University
 *
 */
@Entity

public class University implements Serializable {

	
	private static final long serialVersionUID = 1L;
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private short adres_ID;
	
	
	private String university_Name;

	@OneToMany(mappedBy="university")
	private List<Uye> uyeler;
	
	public short getAdres_ID() {
		return adres_ID;
	}


	public void setAdres_ID(short adres_ID) {
		this.adres_ID = adres_ID;
	}


	public String getUniversity_Name() {
		return university_Name;
	}


	public void setUniversity_Name(String university_Name) {
		this.university_Name = university_Name;
	}


	public List<Uye> getUyeler() {
		return uyeler;
	}


	public void setUyeler(List<Uye> uyeler) {
		this.uyeler = uyeler;
	}
   
}
