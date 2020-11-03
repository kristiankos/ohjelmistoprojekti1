package com.example.ohjelmistoprojekti1;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ohjelmistoprojekti1.domain.Question;
import com.example.ohjelmistoprojekti1.domain.QuestionRepository;


@SpringBootApplication
public class Ohjelmistoprojekti1Application {
	
	private static final Logger log = LoggerFactory.getLogger(Ohjelmistoprojekti1Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Ohjelmistoprojekti1Application.class, args);
	}

	@Bean
	public CommandLineRunner demo(QuestionRepository qrepo) {
		return (args) -> {
			log.info("saving");
			
			ArrayList<String> list = new ArrayList<String>();
			list.add("test");
			list.add("etastata");
			
			qrepo.save(new Question("Title", list));
			
			log.info("fetch a question");
			for (Question question : qrepo.findAll()) {
				log.info(question.toString());
			}
			
		};
	}
}
