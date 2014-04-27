package com.kaykisiz.ceviri.model;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: StudentLanguage
 *
 */
@Entity

public class StudentLanguage implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public StudentLanguage() {
		super();
	}
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int Id;
		
		@ManyToOne
		private Student studentLanguage;
		
		@ManyToOne
		private Language languageStudent;

		public int getId() {
			return Id;
		}

		public void setId(int id) {
			Id = id;
		}

		public Student getStudentLanguage() {
			return studentLanguage;
		}

		public void setStudentLanguage(Student studentLanguage) {
			this.studentLanguage = studentLanguage;
		}

		public Language getLanguageStudent() {
			return languageStudent;
		}

		public void setLanguageStudent(Language languageStudent) {
			this.languageStudent = languageStudent;
		}

		
   
}
