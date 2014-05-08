package com.kaykisiz.ceviri.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Entity implementation class for Entity: Academic
 * 
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "mail"))
public class Academic implements Serializable {

	private static final long serialVersionUID = 1L;

	public Academic() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int academicId;

	@Column(length = 25)
	private String name;

	@Column(length = 25)
	private String surname;

	@Column(length = 16)
	@Size(min=6, max = 16,message="Şifre En az 6 En fazla 16 karakter olmalıdır.")
	private String parola;

	@Column(length = 50, nullable = false)
	@NotEmpty(message = "e-mail adresi boş olamaz!")
	@Email(message = "Lütfen geçerli bir e-mail adresi girin.")
	private String mail;

	@Column(length = 10)
	private String telNumber;

	@Column(length=2)
	private String academicPoint;

	@ManyToOne
	@JoinColumn(name = "titleId")
	private Title title;

	@ManyToOne
	@JoinColumn(name = "universityId")
	private University university;

	@ManyToOne
	@JoinColumn(name = "image_id")
	private Image image;

	@ManyToOne
	@JoinColumn(name = "coverImages_id")
	private CoverImage coverImage;

	@OneToMany(mappedBy = "academicStudent")
	private List<AcademicStudent> academicsStudents;
	
	@OneToMany(mappedBy = "academicLanguage")
	private List<AcademicLanguage> academicLanguages;
	
	@Column(length=600)
	@Size(min=100, max=600, message="En az 100, en fazla 600 karakter !")
	private String about;

	public int getAcademicId() {
		return academicId;
	}

	public void setAcademicId(int academicId) {
		this.academicId = academicId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	public String getAcademicPoint() {
		return academicPoint;
	}

	public void setAcademicPoint(String academicPoint) {
		this.academicPoint = academicPoint;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public CoverImage getCoverImage() {
		return coverImage;
	}

	public void setCoverImage(CoverImage coverImage) {
		this.coverImage = coverImage;
	}

	public List<AcademicStudent> getAcademicsStudents() {
		return academicsStudents;
	}

	public void setAcademicsStudents(List<AcademicStudent> academicsStudents) {
		this.academicsStudents = academicsStudents;
	}

	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}

	public List<AcademicLanguage> getAcademicLanguages() {
		return academicLanguages;
	}

	public void setAcademicLanguages(List<AcademicLanguage> academicLanguages) {
		this.academicLanguages = academicLanguages;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	
}
