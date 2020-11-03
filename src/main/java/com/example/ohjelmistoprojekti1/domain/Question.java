package com.example.ohjelmistoprojekti1.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long questionid;

	private String title;
	private ArrayList<String> body;

	
	public Question() {
		super();
		this.title = null;
		this.body = new ArrayList<String>();
	}

	public Question(String title, ArrayList<String> body) {
		super();
		this.title = title;
		this.body = body;
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

	public List<String> getBody() {
		return body;
	}

	public void setBody(ArrayList<String> body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "Question [questionid=" + questionid + ", title=" + title + ", body=" + body + "]";
	}

}
