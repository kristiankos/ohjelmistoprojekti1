package com.example.ohjelmistoprojekti1.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class QuestionType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long questionTypeId;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "questionType")
	@JsonIgnoreProperties("questiontype")
	private List<Question> questions;
	
	private String type;
	
	
	
	public QuestionType() {
		super();
	}

	public QuestionType(String type) {
		super();
		this.type = type;
	}

	public Long getQuestionTypeId() {
		return questionTypeId;
	}

	public void setQuestionTypeId(Long questionTypeId) {
		this.questionTypeId = questionTypeId;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "QuestionType [questionTypeId=" + questionTypeId + ", type=" + type + "]";
	}
	
	
	
	
	
}
