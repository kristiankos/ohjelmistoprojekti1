package com.example.ohjelmistoprojekti1.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ohjelmistoprojekti1.domain.Question;
import com.example.ohjelmistoprojekti1.domain.QuestionRepository;
import com.example.ohjelmistoprojekti1.domain.Survey;
import com.example.ohjelmistoprojekti1.domain.SurveyRepository;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping(value = "/surveys")
public class SurveyController {

	@Autowired
	SurveyRepository surveyrepo;

	@Autowired
	private QuestionRepository qrepo;

	@Autowired
	QuestionController questioncontroller;

	@GetMapping
	public List<Survey> surveyListRest() {
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

	@PostMapping("{id}/questions")
	public List<Question> addManyQuestionsToSurveyRest(@PathVariable Long id, @RequestBody List<Question> questions) {
		Survey s = surveyrepo.findById(id).get();

		for (int i = 0; i < questions.size(); i++) {
			Question q = questions.get(i);
			q.setSurvey(s);
			qrepo.save(q);
		}

		return findQuestionsBySurveyRest(id);

	}

	@PostMapping
	public @ResponseBody Survey saveSurveyRest(@RequestBody Survey survey) {
		Survey savedSurvey = surveyrepo.save(survey);
//		for (int i = 0; i < survey.getQuestions().size(); i++) {
//			Question q = survey.getQuestions().get(i);
//			q.setSurvey(savedSurvey);
//			qrepo.save(q);
//		}
		return savedSurvey;
	}

	@PutMapping("{id}")
	public @ResponseBody Survey updateSurveyRest(@PathVariable Long id, @RequestBody Survey newSurvey) {
		Survey update = surveyrepo.findById(id).get();
		update.setTitle(newSurvey.getTitle());
		update.setQuestions(newSurvey.getQuestions());
		return surveyrepo.save(update);
	}
}
