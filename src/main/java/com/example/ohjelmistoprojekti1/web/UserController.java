package com.example.ohjelmistoprojekti1.web;

import com.example.ohjelmistoprojekti1.domain.Question;
import com.example.ohjelmistoprojekti1.domain.QuestionRepository;
import com.example.ohjelmistoprojekti1.domain.Survey;
import com.example.ohjelmistoprojekti1.domain.SurveyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    private SurveyRepository surveyrepo;

    @Autowired
    private QuestionRepository questionrepo;
    
    @RequestMapping( value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value= "/addquestion")
    public String addQuestion(Model model) {
        model.addAttribute("question", new Question());

        return "addquestion";
    }

    @RequestMapping(value="/addsurvey")
    public String addSurvey(Model model) {
        model.addAttribute("survey", new Survey());

        return "addsurvey";
    }

    @RequestMapping(value="/savequestion", method = RequestMethod.POST)
    public String saveQuestion(Question question) {
        questionrepo.save(question);
        return "login";
    }

    @RequestMapping(value= "/savesurvey", method = RequestMethod.POST) 
        public String saveSurvey(Survey survey) {
            surveyrepo.save(survey);
            return "redirect";
        }
    
    @RequestMapping(value="/kyselylista")
        public String kyselyLista(Model model) {
            model.addAttribute("kyselyt", surveyrepo.findAll());
            return "kyselylista";
        }
    }
