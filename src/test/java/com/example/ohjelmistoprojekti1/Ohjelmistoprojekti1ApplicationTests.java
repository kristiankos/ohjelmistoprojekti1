package com.example.ohjelmistoprojekti1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.ohjelmistoprojekti1.domain.Survey;
import com.example.ohjelmistoprojekti1.domain.SurveyRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@SpringBootTest
class Ohjelmistoprojekti1ApplicationTests {
	
	@Autowired
	private SurveyRepository surrepo;

	@Test
	public void contextLoads() throws Exception{
		assertThat(surrepo).isNotNull();
	}
	
	@Test
	public void addSurvey() throws Exception {
		Survey survey = new Survey("Testikysely");
		surrepo.save(survey);
		assertThat(survey.getSurveyId()).isNotNull();
		
	}

}
