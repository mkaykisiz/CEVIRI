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
	private Company company;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public byte getStudentPoint() {
		return studentPoint;
	}

	public void setStudentPoint(byte studentPoint) {
		this.studentPoint = studentPoint;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isTranslated() {
		return Translated;
	}

	public void setTranslated(boolean translated) {
		Translated = translated;
	}

	public Academic getAcademic() {
		return academic;
	}

	public void setAcademic(Academic academic) {
		this.academic = academic;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	
}
