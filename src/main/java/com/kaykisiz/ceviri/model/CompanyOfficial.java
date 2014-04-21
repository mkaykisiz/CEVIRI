package com.kaykisiz.ceviri.model;

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
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "mail"))
public class CompanyOfficial implements Serializable {

	private static final long serialVersionUID = 1L;

	public CompanyOfficial() {
		super();
	}

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

	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;

	@ManyToOne
	@JoinColumn(name = "image_id")
	private Image image;

	@ManyToOne
	@JoinColumn(name = "coverImages_id")
	private CoverImage coverImage;

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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
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

}
