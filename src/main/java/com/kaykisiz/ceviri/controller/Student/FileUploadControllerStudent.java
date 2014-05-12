package com.kaykisiz.ceviri.controller.Student;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import org.primefaces.event.FileUploadEvent;

import com.kaykisiz.ceviri.data.Company.MessageAcademicListProducer;
import com.kaykisiz.ceviri.data.Student.StudentofAcademicProducer;
import com.kaykisiz.ceviri.model.Translation;

//Dosya yükleme işlemini gerçekleştirecek.
@Model
@Stateful
public class FileUploadControllerStudent implements Serializable {

	/**
     * 
     */
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;

	@Inject
	private Event<Translation> transEvent;
	
	private Translation translation;
	
	private int selectedAcademicId;
	
	@Inject
	private StudentofAcademicProducer academicProducer;
	
	@Inject
	private StudentSession studentSession;
	
	@Named("TranslationStudent")
	@Produces
	public Translation getTranslation() {
		return translation;
	}

	// Dosya ilk olarak buradan sisteme çekiliyor
	public String UploadFile(FileUploadEvent event) {
		try {
			CopyFile(event.getFile().getFileName(), event.getFile()
					.getInputstream());

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		initTranslation();
		return "FileList.xhtml?faces-redirect=true";
	}

	// Dosya Sisteme ve veritabanına alınır.
	public void CopyFile(String dosya, InputStream in) {
		for (int i = 0; i < academicProducer.getStudentAcademic().size(); i++) {
			if (selectedAcademicId==academicProducer.getStudentAcademic().get(i).getAcademicId()) {
				translation.setAcademic(academicProducer.getStudentAcademic().get(i));
				break;
			}
		}
		
		try {
			// Dosya uygulama sunucusunda bulunan ana dizinimize aktarılıyor.
			// ör:.../paylasim/dosya.jpeg
			OutputStream out = new FileOutputStream(new File(FacesContext
					.getCurrentInstance().getExternalContext().getRealPath("/")
					+ "file/" + dosya));
			int read = 0;
			byte[] bytes = new byte[1024];
			while ((read = in.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}

			in.close();
			out.flush();
			out.close();

			translation.setUrl(dosya);
			translation.setStudent(studentSession.getStudent());
			translation.setTranslated(true);
			entityManager.persist(translation);
			transEvent.fire(translation);

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	// yapıcı yordam
	@PostConstruct
	public void initTranslation() {
		translation = new Translation();

	}

	public int getSelectedAcademicId() {
		return selectedAcademicId;
	}

	public void setSelectedAcademicId(int selectedAcademicId) {
		this.selectedAcademicId = selectedAcademicId;
	}



	

	

}