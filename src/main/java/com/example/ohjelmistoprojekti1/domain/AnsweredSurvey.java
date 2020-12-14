package com.example.ohjelmistoprojekti1.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class AnsweredSurvey {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Long surveyId;

	@OneToMany
	private List<Answer> answers;

	public AnsweredSurvey() {
	}

	public AnsweredSurvey(Long surveyId, List<Answer> answers) {
		super();
		this.surveyId = surveyId;
		this.answers = answers;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(Long surveyId) {
		this.surveyId = surveyId;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	@Override
	public String toString() {
		return "AnsweredSurvey [id=" + id + ", surveyId=" + surveyId + ", answers=" + answers + "]";
	}

}
