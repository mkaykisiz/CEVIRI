package com.kaykisiz.ceviri.data;

import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.ServletContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.kaykisiz.ceviri.controller.Student.StudentSession;
import com.kaykisiz.ceviri.model.Translation;

//Ünvan Listesini getirir.

@RequestScoped
public class FileListProducer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;

	private List<Translation> translations;

	private StreamedContent fileUrl;

	@Inject
	private StudentSession studentSession;

	@Produces
	@Named
	public List<Translation> getTranslations() {
		return translations;
	}

	public void onStudentListChanged(
			@Observes(notifyObserver = Reception.IF_EXISTS) final Translation translations) {
		retrieveAllFile();
	}

	@PostConstruct
	public void retrieveAllFile() {

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Translation> criteriaQuery = criteriaBuilder
				.createQuery(Translation.class);
		Root<Translation> fil = criteriaQuery.from(Translation.class);
		criteriaQuery.select(fil);
		translations = entityManager.createQuery(criteriaQuery).getResultList();

	}

	public void FileDownloadController() {
		InputStream stream = ((ServletContext) FacesContext
				.getCurrentInstance().getExternalContext().getContext())
				.getResourceAsStream(FacesContext.getCurrentInstance()
						.getExternalContext().getRealPath("/")
						+ "file/"
						+ studentSession.getSelectedTranslation().getUrl());
		fileUrl=(new DefaultStreamedContent(stream, "image/jpg",
				"downloaded_optimus.jpg"));
	}

	@Named("FileUrl")
	@Produces
	public StreamedContent getFileUrl() {
		return fileUrl;
	}

}
