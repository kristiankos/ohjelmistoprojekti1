package com.example.ohjelmistoprojekti1.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ohjelmistoprojekti1.domain.Question;
import com.example.ohjelmistoprojekti1.domain.Survey;
import com.example.ohjelmistoprojekti1.domain.SurveyRepository;

@RestController
@RequestMapping(value = "/surveys")
public class SurveyController {

	@Autowired
	SurveyRepository surveyrepo;
	
	@Autowired
	QuestionController questioncontroller;
	
	@GetMapping
	public List<Survey> surveyListRest(){
		return (List<Survey>) surveyrepo.findAll();
	}
	
	@GetMapping("{id}")
	public Optional<Survey> findSurveyRest(@PathVariable Long id) {
		return surveyrepo.findById(id);
	}
	
	@GetMapping("{id}/questions")
	public List<Question> findQuestionsBySurveyRest(@PathVariable Long id) {
		return findSurveyRest(id).get().getQuestions();
	}
	
	@PostMapping
	public @ResponseBody Survey saveSurveyRest(@RequestBody Survey survey) {
		return surveyrepo.save(survey);
	}
	
	
	
}
