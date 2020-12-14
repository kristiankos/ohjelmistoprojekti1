package com.example.ohjelmistoprojekti1.web;

import com.example.ohjelmistoprojekti1.domain.Question;
import com.example.ohjelmistoprojekti1.domain.QuestionRepository;
import com.example.ohjelmistoprojekti1.domain.Survey;
import com.example.ohjelmistoprojekti1.domain.SurveyRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

	@Autowired
	private SurveyRepository surveyrepo;

	@Autowired
	private QuestionRepository questionrepo;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}


	@RequestMapping(value = "/addsurvey")
	public String addSurvey(Model model) {
		model.addAttribute("survey", new Survey());

		return "addsurvey";
	}


	@RequestMapping(value = "/savesurvey", method = RequestMethod.POST)
	public String saveSurvey(Survey survey) {
		surveyrepo.save(survey);
		return "redirect:kyselylista";
	}

	@RequestMapping(value = "/kyselylista")
	public String kyselyLista(Model model) {
		model.addAttribute("kyselyt", surveyrepo.findAll());
		return "kyselylista";
	}

	@RequestMapping(value = "/modifysurvey/{id}")
	public String editSurvey(@PathVariable("id") Long surveyId, Model model) {
		model.addAttribute("survey", surveyrepo.findById(surveyId));
		model.addAttribute("questions", surveyrepo.findById(surveyId).get().getQuestions());
		return "modifysurvey";
	}

	@RequestMapping(value = "/deletesurvey/{id}", method = RequestMethod.GET)
	public String deleteSurvey(@PathVariable("id") Long surveyId, Model model) {
		surveyrepo.deleteById(surveyId);
		return "redirect:../kyselylista";
	}
	
	@RequestMapping(value= "/deletequestion/{id}")
	public String deleteQuestion(@PathVariable("id") Long questionId) {
		questionrepo.deleteById(questionId);
		return "redirect:../kyselylista";
	}

	@RequestMapping(value = "/addquestion/{id}")
	public String addQuestion(@PathVariable("id") Long surveyId, Model model) {
		Question question = new Question(surveyrepo.findById(surveyId).get(), null, null, null);
		model.addAttribute("question", question);
		
		return "addquestion";
	}

	@RequestMapping(value = "/savequestion", method = RequestMethod.POST)
	public String saveQuestion(Question question) {
		questionrepo.save(question);
		return "redirect:../kyselylista";
	}

}
