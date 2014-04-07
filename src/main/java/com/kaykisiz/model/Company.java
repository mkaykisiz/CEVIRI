package com.kaykisiz.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Entity implementation class for Entity: Firma
 * 
 */
@Entity
public class Company implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CompanyId;
	@Column(length = 60)
	private String name;
	@Column(length = 250)
	private String address;
	@Size(min = 1, max = 10)
	private byte companyPoint;

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
}
