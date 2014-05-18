package com.kaykisiz.ceviri.controller.Academic;

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

import com.kaykisiz.ceviri.data.Academic.StudentListProducer;
import com.kaykisiz.ceviri.model.AcademicStudent;

;

@Stateful
@Model
public class StudentAddedbyAcademic {
	@Inject
	private EntityManager entityManager;

	@Inject
	private FacesContext facesContext;

	@Inject
	private Event<AcademicStudent> academicStudentEvent;

	private AcademicStudent academicStudent;

	@Inject
	private AcademicSession academicSession;

	@Inject
	private StudentListProducer studentListProducer;

	@Named
	@Produces
	public AcademicStudent getAcademicStudent() {
		return academicStudent;
	}

	public StudentListProducer getStudentListProducer() {
		return studentListProducer;
	}

	public void setStudentListProducer(StudentListProducer studentListProducer) {
		this.studentListProducer = studentListProducer;
	}

	public String studentAddedbyAcademic() {
		
		academicStudent.setStudentAcademic(academicSession.getSelectedStudent());
		academicStudent.setAcademicStudent(academicSession.getAcademic());


		try {
			entityManager.persist(academicStudent);
			academicStudentEvent.fire(academicStudent);
			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Kayıt Başarılı !",
					"Kayıt Başarılı !"));
			initStudentAddedbyAcademic();

		} catch (Exception e) {
			e.printStackTrace();

			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Kayıt Başarısız !",
					"Kayıt Başarısız !"));
		}
		return "/Academic/StudentSearch/index.xhtml?faces-redirect=true";

	}

	@PostConstruct
	public void initStudentAddedbyAcademic() {
		academicStudent = new AcademicStudent();
	}

}
