package com.kaykisiz.ceviri.controller.Company;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import com.kaykisiz.ceviri.model.Company;

@Stateful
@Model
public class CompanyRegister {

	@Inject
	private EntityManager entityManager;

	@Inject
	private FacesContext facesContext;

	@Inject
	private Event<Company> companyEvent;

	private Company company;

	@Named
	@Produces
	public Company getCompany() {
		return company;
	}


	public void registerCompany() {
	
		try {
			entityManager.persist(company);
			companyEvent.fire(company);
			
			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO,
					"Firma kaydı başarıyla yapıldı.", company.getName() + " "
							+ company.getName() + "Aramıza Hoş Gelidin"));

			initCompany();

		} catch (Exception e) {
			e.printStackTrace();
			
			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Firma kaydedilemedi!",
					"Firma kaydedilemedi!"));
		}

	}

	@PostConstruct
	public void initCompany() {
		company = new Company();
	}

}
