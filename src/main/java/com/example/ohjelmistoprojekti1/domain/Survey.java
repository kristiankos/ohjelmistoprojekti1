package com.example.ohjelmistoprojekti1.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Survey {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long surveyId;
	
	private String title;
	
//	private boolean active;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "survey")
	@JsonIgnoreProperties("survey")
	private List<Question> questions = new ArrayList<Question>();

	
	public Survey() {
		super();
	}
	
	
	

	public Survey(String title, List<Question> questions) {
		super();
		this.title = title;
		this.questions = questions;
	}




	public Survey(String title) {
		super();
		this.title = title;
	}




	public Long getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(Long surveyId) {
		this.surveyId = surveyId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

//	public boolean isActive() {
//		return active;
//	}

//	public void setActive(boolean active) {
//		this.active = active;
//	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}




	@Override
	public String toString() {
		return "Survey [surveyId=" + surveyId + ", title=" + title + ", questions=" + questions + "]";
	}
	
	
	
	
	
	
}
