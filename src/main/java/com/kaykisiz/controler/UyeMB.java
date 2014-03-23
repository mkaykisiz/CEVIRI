package com.kaykisiz.controler;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import com.kaykisiz.model.Uye;

@Model
@Stateful
public class UyeMB {

	@Inject
	private EntityManager entityManager;

	private Uye uye;

	@Named
	@Produces
	public Uye getUye() {
		return uye;
	}

	public void kaydet() {

		try {
			entityManager.persist(uye);			
		} catch (Exception e) {
			System.err.println(e.getMessage().toString());
		}

	}

	@PostConstruct
	public void initUye() {
		uye = new Uye();
	}

}
