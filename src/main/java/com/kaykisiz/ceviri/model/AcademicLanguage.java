package com.kaykisiz.ceviri.model;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: AcademicLanguage
 *
 */
@Entity

public class AcademicLanguage implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public AcademicLanguage() {
		super();
	}
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int Id;
		
		@ManyToOne
		private Academic academicLanguage;
		
		@ManyToOne
		private Language languageacademic;

		public int getId() {
			return Id;
		}

		public void setId(int id) {
			Id = id;
		}

		public Academic getAcademicLanguage() {
			return academicLanguage;
		}

		public void setAcademicLanguage(Academic academicLanguage) {
			this.academicLanguage = academicLanguage;
		}

		public Language getLanguageacademic() {
			return languageacademic;
		}

		public void setLanguageacademic(Language languageacademic) {
			this.languageacademic = languageacademic;
		}


		
		
}
