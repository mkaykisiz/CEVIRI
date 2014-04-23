package com.kaykisiz.ceviri.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Message
 *
 */
@Entity

public class Message implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Message() {
		super();
	}
   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private short id;
	
	@Column(length=180)
	private String title;
	
	@ManyToOne
	private Academic academic;
	
	@ManyToOne
	private Student student;
	
	@ManyToOne
	private Company company;

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public void setCompanyOfficial(Company company) {
		this.company = company;
	}
	
	
}
