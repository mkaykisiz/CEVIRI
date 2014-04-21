package com.kaykisiz.ceviri.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * Entity implementation class for Entity: Student
 * 
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "mail"))
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;

	@Column(length = 25)
	private String name;

	@Column(length = 25)
	private String surname;

	@Column(length = 50, nullable = false)
	@NotEmpty(message = "e-mail adresi boş olamaz!")
	@Email(message = "Lütfen geçerli bir e-mail adresi girin.")
	private String mail;

	@Column(length = 10)
	private String telNumber;

	@Size(min = 1, max = 10)
	private byte studentPoint;

	@ManyToOne
	@JoinColumn(name = "university_id")
	private University university;

	@ManyToOne
	@JoinColumn(name = "image_id")
	private Image image;

	@ManyToOne
	@JoinColumn(name = "coverImages_id")
	private CoverImage coverImage;

	@OneToMany(mappedBy="student")
	private List<AcademicsStudents> academicsStudents;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
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

	public byte getStudentPoint() {
		return studentPoint;
	}

	public void setStudentPoint(byte studentPoint) {
		this.studentPoint = studentPoint;
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

	public List<AcademicsStudents> getAcademicsStudents() {
		return academicsStudents;
	}

	public void setAcademicsStudents(List<AcademicsStudents> academicsStudents) {
		this.academicsStudents = academicsStudents;
	}
	
	



}
