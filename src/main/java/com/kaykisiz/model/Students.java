package com.kaykisiz.model;

import java.io.Serializable;
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
public class Students implements Serializable {

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

}
