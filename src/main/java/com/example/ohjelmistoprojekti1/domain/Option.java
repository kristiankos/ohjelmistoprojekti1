package com.example.ohjelmistoprojekti1.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Option {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long optionId;
	
	@ManyToOne
	@JsonIgnoreProperties("options")
	private Question question;
	
	private String value;

	public Option() {
		super();
	}



	public Option(Question question, String value) {
		super();
		this.question = question;
		this.value = value;
	}

	public Long getOptionId() {
		return optionId;
	}

	public void setOptionId(Long optionId) {
		this.optionId = optionId;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Option [optionId=" + optionId + ", question=" + question + ", value=" + value + "]";
	}
	
	
	

}
