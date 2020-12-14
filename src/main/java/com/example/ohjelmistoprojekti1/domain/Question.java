package com.example.ohjelmistoprojekti1.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long questionid;

	@ManyToOne
	@JsonIgnoreProperties("questions")
	private Survey survey;

	@Enumerated(EnumType.STRING)
	private QuestionTypeEnum questiontype;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
	@JsonIgnoreProperties("question")
	private List<Option> options;

	private String title;

	public Question() {
		super();
	}

	public Question(Survey survey, QuestionTypeEnum questiontype, List<Option> options, String title) {
		super();
		this.survey = survey;
		this.questiontype = questiontype;
		this.options = options;
		this.title = title;
	}

	public Long getQuestionid() {
		return questionid;
	}

	public void setQuestionid(Long questionid) {
		this.questionid = questionid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	public QuestionTypeEnum getQuestiontype() {
		return questiontype;
	}

	public void setQuestiontype(QuestionTypeEnum questiontype) {
		this.questiontype = questiontype;
	}

	@Override
	public String toString() {
		return "Question [questionid=" + questionid + ", survey=" + survey + ", questiontype=" + questiontype
				+ ", options=" + options + ", title=" + title + "]";
	}

	
}
