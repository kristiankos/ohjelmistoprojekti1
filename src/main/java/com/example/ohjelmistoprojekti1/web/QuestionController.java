package com.example.ohjelmistoprojekti1.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.ohjelmistoprojekti1.domain.Question;
import com.example.ohjelmistoprojekti1.domain.QuestionRepository;

@Controller
public class QuestionController {

	@Autowired
	private QuestionRepository qrepo;

	@GetMapping(value = "/getquestions")
	public @ResponseBody List<Question> getQuestions() {
		return (List<Question>) qrepo.findAll();
	}

}
