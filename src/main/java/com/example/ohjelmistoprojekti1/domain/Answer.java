package com.example.ohjelmistoprojekti1.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Answer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long answerId;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnoreProperties("answers")
	private Question question;
	
	
	private String value;
	
	
	public Answer() {
		super();
	}
	
	

	public Answer(Question question, String value) {
		super();
		this.question = question;
		this.value = value;
	}



	public Answer(String value) {
		super();
		this.value = value;
	}


	public Long getAnswerId() {
		return answerId;
	}

	public void setAnswerId(Long answerId) {
		this.answerId = answerId;
	}



	public String getValue() {
		return value;
	}



	public void setValue(String value) {
		this.value = value;
	}


	

	public Question getQuestion() {
		return question;
	}



	public void setQuestion(Question question) {
		this.question = question;
	}



	@Override
	public String toString() {
		return "Answer [answerId=" + answerId + ", question=" + question + ", value=" + value
				+ "]";
	}


	
}
