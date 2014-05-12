package com.kaykisiz.ceviri.controller;

import java.io.InputStream;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.kaykisiz.ceviri.controller.Student.StudentSession;

@RequestScoped
public class FileDownloadController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private StreamedContent fileUrl;

	@Inject
	private StudentSession studentSession;

	@PostConstruct
	public void FileDownloadControllers() {
		
		System.out.println(studentSession.getSelectedTranslation());
		
		InputStream stream = ((ServletContext) FacesContext
				.getCurrentInstance().getExternalContext().getContext())
				.getResourceAsStream(FacesContext.getCurrentInstance()
						.getExternalContext().getRealPath("/")
						+ "file/"
						+ studentSession.getSelectedTranslation().getUrl());
		fileUrl = new DefaultStreamedContent(stream, "image/jpg",
				"downloaded_optimus.jpg");
	}

	@Named
	@Produces
	public StreamedContent getFileUrl() {
		return fileUrl;
	}

}
