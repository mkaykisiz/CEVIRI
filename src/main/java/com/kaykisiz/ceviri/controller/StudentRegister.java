package com.kaykisiz.ceviri.controller;

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

import com.kaykisiz.ceviri.data.UniversityListProducer;
import com.kaykisiz.ceviri.model.Student;

@Stateful
@Model
public class StudentRegister {

	@Inject
	private EntityManager entityManager;

	@Inject
	private FacesContext facesContext;

	@Inject
	private Event<Student> academicEvent;

	private Student student;

	private int selectedUniversityId;

	@Inject
	private UniversityListProducer universtiyListProducer;

	@Named
	@Produces
	public Student getStudent() {
		return student;
	}

	public int getSelectedUniversityId() {
		return selectedUniversityId;
	}

	public void setSelectedUniversityId(int selectedUniversityId) {
		this.selectedUniversityId = selectedUniversityId;
	}

	public UniversityListProducer getUniverstiyListProducer() {
		return universtiyListProducer;
	}

	public void setUniverstiyListProducer(
			UniversityListProducer universtiyListProducer) {
		this.universtiyListProducer = universtiyListProducer;
	}

	public String registerStudent() {
		for (int i = 0; i < universtiyListProducer.getUniversities().size(); i++) {
			if (selectedUniversityId == universtiyListProducer
					.getUniversities().get(i).getUniversityId()) {
				student.setUniversity(universtiyListProducer.getUniversities()
						.get(i));
				break;
			}
		}
	

		try {
			entityManager.persist(student);
			academicEvent.fire(student);
			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO,
					"Bölüm kaydı başarıyla yapıldı.", student.getName() + " "
							+ student.getSurname() + "Aramıza Hoş Gelidin"));

			initStudent();

		} catch (Exception e) {
			e.printStackTrace();
			if (selectedUniversityId == -1) {
				facesContext.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_WARN,
						"Bir Üniversite Seçmelisiniz !",
						"Bir Üniversite Seçmelisiniz !"));
			}
			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Bölüm kaydedilemedi!",
					"Bölüm kaydedilemedi!"));
		}
		return "StudentLoginRegister/index.xhtml?faces-redirect=true";

	}

	@PostConstruct
	public void initStudent() {
		student = new Student();
	}

}
