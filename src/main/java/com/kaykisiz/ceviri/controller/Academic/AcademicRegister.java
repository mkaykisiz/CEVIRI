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

import com.kaykisiz.ceviri.data.Academic.TitleListProducer;
import com.kaykisiz.ceviri.data.Academic.UniversityListProducer;
import com.kaykisiz.ceviri.model.Academic;

@Stateful
@Model
public class AcademicRegister {

	@Inject
	private EntityManager entityManager;

	@Inject
	private FacesContext facesContext;

	@Inject
	private Event<Academic> academicEvent;

	private Academic academic;

	private int selectedUniversityId;
	
	private int selectedTitleId;

	@Inject
	private UniversityListProducer universtiyListProducer;
	
	@Inject
	private TitleListProducer titleListProducer;

	@Named
	@Produces
	public Academic getAcademic() {
		return academic;
	}

		
	public int getSelectedTitleId() {
		return selectedTitleId;
	}



	public void setSelectedTitleId(int selectedTitleId) {
		this.selectedTitleId = selectedTitleId;
	}



	public TitleListProducer getTitleListProducer() {
		return titleListProducer;
	}



	public void setTitleListProducer(TitleListProducer titleListProducer) {
		this.titleListProducer = titleListProducer;
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

	public void registerAcademic() {
		for (int i = 0; i < universtiyListProducer.getUniversities().size(); i++) {
			if (selectedUniversityId==universtiyListProducer.getUniversities().get(i).getUniversityId()) {
				academic.setUniversity(universtiyListProducer.getUniversities().get(i));
				break;
			}
		}
		for (int i = 0; i < titleListProducer.getTitles().size(); i++) {
			if (selectedTitleId==titleListProducer.getTitles().get(i).getTitleId()) {
				academic.setTitle(titleListProducer.getTitles().get(i));
				break;
			}
		}
		
		try {
			entityManager.persist(academic);
			academicEvent.fire(academic);
			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO,
					"Bölüm kaydı başarıyla yapıldı.", academic.getName()
							+ " "+ academic.getSurname()
							+ "Aramıza Hoş Gelidin"));
			
			initAcademic();
			
		} catch (Exception e) {
			e.printStackTrace();
			if (selectedUniversityId == -1) {
				facesContext.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_WARN,
						"Bir Üniversite Seçmelisiniz !",
						"Bir Üniversite Seçmelisiniz !"));
			}
			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Kayıt Başarısız !",
					"Kayıt Başarısız !"));
		}
		
		
		
	}

	@PostConstruct
	public void initAcademic() {
		academic = new Academic();
	}

}
