package com.example.ohjelmistoprojekti1.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
	
	private String option;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "option")
	@JsonIgnoreProperties("option")
	private List<Answer> answers;
	
	public Option() {
		super();
	}
	
	
	public Option(Question question, String option) {
		super();
		this.question = question;
		this.option = option;
	}


	public Option(String option) {
		super();
		this.option = option;
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

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	
	

}
