package com.kaykisiz.ceviri.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Entity implementation class for Entity: Translation
 *
 */
@Entity

public class Translation implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Translation() {
		super();
	}
   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=180)
	@Size(max=180, message="Max. 180 karakter !")
	private String title;	

	@Size(min = 1, max = 10)
	private byte studentPoint;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	private boolean Translated;
	
	@ManyToOne
	private Academic academic;
	
	@ManyToOne
	private Student student;
	
	@ManyToOne
	private CompanyOfficial companyOfficial;
}
