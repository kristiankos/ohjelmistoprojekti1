package com.example.ohjelmistoprojekti1.domain;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Kysely {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long kyselyid;

	private String title;
	private ArrayList<Question> questions;

	public Kysely() {
		super();
	}

	public Kysely(String title, ArrayList<Question> questions) {
		super();
		this.title = title;
		this.questions = questions;
	}

	public Long getKyselyid() {
		return kyselyid;
	}

	public void setKyselyid(Long kyselyid) {
		this.kyselyid = kyselyid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ArrayList<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(ArrayList<Question> questions) {
		this.questions = questions;
	}

	
	
	
	
}
