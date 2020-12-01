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
import com.example.ohjelmistoprojekti1.domain.QuestionRepository;

@RestController
@RequestMapping("/questions")
public class QuestionController {

	@Autowired
	private QuestionRepository qrepo;

	@GetMapping
	public List<Question> questionListRest() {
		return (List<Question>) qrepo.findAll();
	}
	
	@GetMapping("{id}")
	public Optional<Question> findQuestionRest(@PathVariable Long id) {
		return qrepo.findById(id);
	}

	@PostMapping
	public @ResponseBody Question saveQuestionRest(@RequestBody Question question) {
		return qrepo.save(question);
	}

	
}
