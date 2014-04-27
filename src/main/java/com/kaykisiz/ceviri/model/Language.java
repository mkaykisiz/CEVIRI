package com.kaykisiz.ceviri.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Language
 *
 */
@Entity

public class Language implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Language() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	
	@Column(length=180)
	private String language;
	
	@OneToMany(mappedBy="languageacademic")
	private List<AcademicLanguage> academicLanguages;
	
	@OneToMany(mappedBy = "languageStudent")
	private List<StudentLanguage> studentLanguages;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public List<AcademicLanguage> getAcademicLanguages() {
		return academicLanguages;
	}

	public void setAcademicLanguages(List<AcademicLanguage> academicLanguages) {
		this.academicLanguages = academicLanguages;
	}

	public List<StudentLanguage> getStudentLanguages() {
		return studentLanguages;
	}

	public void setStudentLanguages(List<StudentLanguage> studentLanguages) {
		this.studentLanguages = studentLanguages;
	}

	
	
}
