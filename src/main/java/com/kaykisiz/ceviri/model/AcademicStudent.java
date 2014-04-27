package com.kaykisiz.ceviri.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: AcademicsStudents
 * 
 */
@Entity
public class AcademicStudent implements Serializable {

	private static final long serialVersionUID = 1L;

	public AcademicStudent() {
		super();
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	
	@ManyToOne
	private Academic academicStudent;
	
	@ManyToOne
	private Student studentAcademic;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Academic getAcademicStudent() {
		return academicStudent;
	}

	public void setAcademicStudent(Academic academicStudent) {
		this.academicStudent = academicStudent;
	}

	public Student getStudentAcademic() {
		return studentAcademic;
	}

	public void setStudentAcademic(Student studentAcademic) {
		this.studentAcademic = studentAcademic;
	}
	
	
}
