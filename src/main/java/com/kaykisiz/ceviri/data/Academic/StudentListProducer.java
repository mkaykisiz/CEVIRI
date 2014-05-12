package com.kaykisiz.ceviri.data.Academic;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.kaykisiz.ceviri.controller.Academic.AcademicSession;
import com.kaykisiz.ceviri.model.Student;

//Ünvan Listesini getirir.

@RequestScoped
public class StudentListProducer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;

	private List<Student> students;

	@Inject
	private AcademicSession academicSession;
	
	@Produces
	@Named
	public List<Student> getStudents() {
		return students;
	} 



	public void onStudentListChanged(
			@Observes(notifyObserver = Reception.IF_EXISTS) final Student students) {
		retrieveAllStudents();
	}

	@PostConstruct
	public void retrieveAllStudents() {
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Student> criteriaQuery = criteriaBuilder
				.createQuery(Student.class);
		Root<Student> std = criteriaQuery.from(Student.class);
		criteriaQuery.where(criteriaBuilder.equal(std.get("university"), academicSession.getAcademic().getUniversity().getUniversityId()));
		students = entityManager.createQuery(criteriaQuery).getResultList();
		System.out.println("asadad");
	}
}

