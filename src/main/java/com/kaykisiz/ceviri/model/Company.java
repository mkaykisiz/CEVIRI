package com.kaykisiz.ceviri.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Entity implementation class for Entity: Firma
 * 
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "mail"))
public class Company implements Serializable {

	private static final long serialVersionUID = 1L;
	

	public Company() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CompanyId;

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Column(length = 60)
	private String name;
	
	@Column(length = 250)
	private String address;
	
	@Column(length = 50, nullable = false)
	@NotEmpty(message = "e-mail adresi boş olamaz!")
	@Email(message = "Lütfen geçerli bir e-mail adresi girin.")
	private String mail;
	
	@Size(min = 1, max = 10)
	private byte companyPoint;

	@ManyToOne
	@JoinColumn(name = "image_id")
	private Image image;
	
	@ManyToOne
	@JoinColumn(name = "coverImages_id")
	private CoverImage coverImage;

	public int getCompanyId() {
		return CompanyId;
	}

	public void setCompanyId(int companyId) {
		CompanyId = companyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public byte getCompanyPoint() {
		return companyPoint;
	}

	public void setCompanyPoint(byte companyPoint) {
		this.companyPoint = companyPoint;
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
