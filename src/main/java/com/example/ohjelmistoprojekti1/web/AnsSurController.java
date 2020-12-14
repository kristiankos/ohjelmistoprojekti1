package com.example.ohjelmistoprojekti1.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ohjelmistoprojekti1.domain.Answer;
import com.example.ohjelmistoprojekti1.domain.AnswerRepository;
import com.example.ohjelmistoprojekti1.domain.AnsweredSurvey;
import com.example.ohjelmistoprojekti1.domain.AnsweredSurveyRepository;

@RestController
@CrossOrigin
public class AnsSurController {
	
	@Autowired
	AnsweredSurveyRepository anssurrepo;
	
	@Autowired
	AnswerRepository answerrepo;
	
	@GetMapping("/anssurs")
	public List<AnsweredSurvey> getAnsSur() {
		return (List<AnsweredSurvey>) anssurrepo.findAll();
	}
	
	@PostMapping("/anssurs")
	public @ResponseBody AnsweredSurvey saveAnsSur(@RequestBody AnsweredSurvey anssur) {
		List <Answer> answers = new ArrayList<Answer>();
		for(Answer answer : anssur.getAnswers()) {
			System.out.println(answer);
			answers.add(answerrepo.save(answer));
		}
		
		AnsweredSurvey anssuretosave = new AnsweredSurvey(anssur.getSurveyId(), answers);
		return anssurrepo.save(anssuretosave);
		
	}

}
