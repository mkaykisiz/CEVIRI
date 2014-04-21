package com.kaykisiz.ceviri.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: AcademicsStudents
 * 
 */
@Entity
public class AcademicsStudents implements Serializable {

	private static final long serialVersionUID = 1L;

	public AcademicsStudents() {
		super();
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	
	@ManyToOne
	private Academic academic;
	
	@ManyToOne
	private Student student;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
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
}
