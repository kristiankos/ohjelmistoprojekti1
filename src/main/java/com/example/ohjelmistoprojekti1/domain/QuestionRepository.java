package com.example.ohjelmistoprojekti1.domain;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Long> {

	List<Question> findBySurveyId(Long surveyId);

	

}