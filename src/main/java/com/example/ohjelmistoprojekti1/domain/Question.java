package com.example.ohjelmistoprojekti1.domain;

import java.util.ArrayList;
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
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long questionid;

	@ManyToOne
	@JsonIgnoreProperties("questions")
	private Survey survey;
	
	@ManyToOne
	@JsonIgnoreProperties("questions")
	private QuestionType questionType;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
	@JsonIgnoreProperties("question")
	private List<Option> options;

	
	private String title;
//	private ArrayList<String> body;

	
	
	
	
	
	public Question() {
		super();
//		this.title = null;
//		this.body = new ArrayList<String>();
	}

	
	
	
	public Question(Survey survey, QuestionType questionType, String title) {
		super();
		this.survey = survey;
		this.questionType = questionType;
		this.title = title;
	}




	public Question(String title, QuestionType questionType) {
		super();
		this.title = title;
		this.questionType = questionType;
	}




	public Question(Survey survey, QuestionType questionType, List<Option> options, String title) {
		super();
		this.survey = survey;
		this.questionType = questionType;
		this.options = options;
		this.title = title;
	}




	public Question(String title, ArrayList<String> body) {
		super();
		this.title = title;
//		this.body = body;
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




	public QuestionType getQuestionType() {
		return questionType;
	}




	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}
	
	

//	public List<String> getBody() {
//		return body;
//	}

//	public void setBody(ArrayList<String> body) {
//		this.body = body;
//	}

//	@Override
//	public String toString() {
//		return "Question [questionid=" + questionid + ", title=" + title + ", body=" + body + "]";
//	}

}
