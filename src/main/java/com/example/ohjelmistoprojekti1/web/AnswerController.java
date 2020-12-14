package com.example.ohjelmistoprojekti1.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ohjelmistoprojekti1.domain.Answer;
import com.example.ohjelmistoprojekti1.domain.AnswerRepository;

@RestController
@RequestMapping("/answers")
public class AnswerController {
	
	@Autowired
	AnswerRepository answerrepo;
	
	@GetMapping
	public List<Answer> getAnswersRest(){
		return (List<Answer>) answerrepo.findAll();
	}
	
	@PostMapping
	public Answer saveAnswerRest(@RequestBody Answer answer) {
		return answerrepo.save(answer);
	}
	
	
}
