package com.example.ohjelmistoprojekti1.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AnsweredSurveyRepository extends CrudRepository<AnsweredSurvey, Long>{

	List<AnsweredSurvey> findAllBySurveyId(Long surveyId);
	


}
