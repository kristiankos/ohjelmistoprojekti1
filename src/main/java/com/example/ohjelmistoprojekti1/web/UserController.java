package com.example.ohjelmistoprojekti1.web;

import com.example.ohjelmistoprojekti1.domain.Answer;
import com.example.ohjelmistoprojekti1.domain.AnswerRepository;
import com.example.ohjelmistoprojekti1.domain.AnsweredSurvey;
import com.example.ohjelmistoprojekti1.domain.AnsweredSurveyRepository;
import com.example.ohjelmistoprojekti1.domain.Option;
import com.example.ohjelmistoprojekti1.domain.OptionRepository;
import com.example.ohjelmistoprojekti1.domain.Question;
import com.example.ohjelmistoprojekti1.domain.QuestionRepository;
import com.example.ohjelmistoprojekti1.domain.Survey;
import com.example.ohjelmistoprojekti1.domain.SurveyRepository;

import java.util.List;
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
	
	@Autowired
	private OptionRepository optionrepo;
	
	@Autowired
	private AnsweredSurveyRepository anssurrepo;
	
	@Autowired
	private AnswerRepository ansrepo;
	
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
		model.addAttribute("surveyId", surveyId);
		return "modifysurvey";
	}

	@RequestMapping(value = "/deletesurvey/{id}", method = RequestMethod.GET)
	public String deleteSurvey(@PathVariable("id") Long surveyId, Model model) {
		surveyrepo.deleteById(surveyId);
		return "redirect:../kyselylista";
	}
	
	@RequestMapping(value = "/active/{id}", method = RequestMethod.GET)
	public String changeActiveSurvey(@PathVariable("id") Long surveyId) {
		Survey survey = surveyrepo.findById(surveyId).get();
		if (survey.isActive()) {
			survey.setActive(false);
		} else {
			survey.setActive(true);
		}
		surveyrepo.save(survey);
		return "redirect:../kyselylista";
	}
	
	@RequestMapping(value= "/deletequestion/{id}")
	public String deleteQuestion(@PathVariable("id") Long questionId) {
		questionrepo.deleteById(questionId);
		return "redirect:../kyselylista";
	}
	
	@RequestMapping(value= "/deleteoption/{id}")
	public String deleteOption(@PathVariable("id") Long optionId) {
		optionrepo.deleteById(optionId);
		return "redirect:../kyselylista";
	}

	@RequestMapping(value = "/addquestion/{id}")
	public String addQuestion(@PathVariable("id") Long surveyId, Model model) {
		Question question = new Question();
		model.addAttribute("question", question);
		model.addAttribute("surveyId", surveyId);
		return "addquestion";
	}
	
	@RequestMapping(value = "/addoption/{id}")
	public String addOption(@PathVariable("id") Long questionId, Model model) {
		Option option = new Option();
		model.addAttribute("option", option);
		model.addAttribute("questionId", questionId);
		return "addoption";
	}


	@RequestMapping(value = "/savequestion/{id}", method = RequestMethod.POST)
	public String saveQuestion(@PathVariable("id") Long surveyId, Question question) {
		Survey survey = surveyrepo.findById(surveyId).get();
		question.setSurvey(survey);
		questionrepo.save(question);
		
		return "redirect:../kyselylista";
	}
	
	@RequestMapping(value = "/saveoption/{id}", method = RequestMethod.POST)
	public String saveOption(@PathVariable("id") Long questionId, Option option) {
		Question question = questionrepo.findById(questionId).get();
		option.setQuestion(question);
		optionrepo.save(option);
		
		return "redirect:../kyselylista";
	}
	
	@RequestMapping(value = "/modifyquestion/{id}")
	public String editQuestion(@PathVariable("id") Long questionId, Model model) {
		model.addAttribute("question", questionrepo.findById(questionId));
		model.addAttribute("options", questionrepo.findById(questionId).get().getOptions());
		model.addAttribute("questionId", questionId);
		return "modifyquestion";
	}
	
	@RequestMapping(value = "/getanswers/{id}")
	public String getAnswersBySurvey(@PathVariable("id") Long surveyId, Model model) {
		List<AnsweredSurvey> anssurs = anssurrepo.findAllBySurveyId(surveyId);
		Survey survey = surveyrepo.findById(surveyId).get();
		model.addAttribute("survey", survey);
		model.addAttribute("questions", surveyrepo.findById(surveyId).get().getQuestions());
		model.addAttribute("anssurs", anssurs);
		model.addAttribute("maara", anssurs.size());
		
		return "answerlist";
	}

	@RequestMapping(value = "/getanswersbyquestion/{id}")
	public String getAnswersByQuestion(@PathVariable("id") Long questionId, Model model) {
		List<Answer> answers = ansrepo.findAllByquestionId(questionId);
		model.addAttribute("answers", answers);
		return "questionanswers";
	}
}
