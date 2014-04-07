package com.kaykisiz.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Entity implementation class for Entity: CompanyOfficial
 * 
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class CompanyOfficial implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int companyOfficialId;
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

	public int getCompanyOfficialId() {
		return companyOfficialId;
	}

	public void setCompanyOfficialId(int companyOfficialId) {
		this.companyOfficialId = companyOfficialId;
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
}
