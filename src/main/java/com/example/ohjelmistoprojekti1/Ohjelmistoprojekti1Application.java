package com.example.ohjelmistoprojekti1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.example.ohjelmistoprojekti1.domain.Answer;
import com.example.ohjelmistoprojekti1.domain.AnswerRepository;
import com.example.ohjelmistoprojekti1.domain.Option;
import com.example.ohjelmistoprojekti1.domain.OptionRepository;
import com.example.ohjelmistoprojekti1.domain.Question;
import com.example.ohjelmistoprojekti1.domain.QuestionRepository;
import com.example.ohjelmistoprojekti1.domain.QuestionTypeEnum;
import com.example.ohjelmistoprojekti1.domain.Survey;
import com.example.ohjelmistoprojekti1.domain.SurveyRepository;
import com.example.ohjelmistoprojekti1.domain.User;
import com.example.ohjelmistoprojekti1.domain.UserRepository;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class Ohjelmistoprojekti1Application {
	
	private static final Logger log = LoggerFactory.getLogger(Ohjelmistoprojekti1Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Ohjelmistoprojekti1Application.class, args);
	}

	

	@Bean
	public CommandLineRunner demo(SurveyRepository survrepo, QuestionRepository qrepo, OptionRepository oprepo, AnswerRepository ansrepo, UserRepository urepo) {
		return (args) -> {
			log.info("saving");
			//Luodaan admin käyttäjä
			User admin = new User("admin","admin","ADMIN");
			urepo.save(admin);
			
			// Pari esimerkki kyselyä
			Survey kysely1 = new Survey("Kyselyn1 otsikko");
			survrepo.save(kysely1);
			
			Survey kysely2 = new Survey("Kyselyn2 otsikko");
			survrepo.save(kysely2);
			
			Survey kysely3 = new Survey("Kyselyn3 otsikko");
			survrepo.save(kysely3);
			
			Survey kysely4 = new Survey("Kyselyn4 otsikko");
			survrepo.save(kysely4);
			
			Survey kysely5 = new Survey("Kyselyn5 otsikko");
			survrepo.save(kysely5);
			
			
		
			
			QuestionTypeEnum RADIO = QuestionTypeEnum.RADIO;
			Question kysymys1 = new Question(kysely1, RADIO, "Mitä kuuluu?");
			qrepo.save(kysymys1);
			
			
			Option hyvaa = new Option(kysymys1, "Hyvää");
			oprepo.save(hyvaa);
			Option pahaa = new Option(kysymys1, "Pahaa");
			oprepo.save(pahaa);
			Option eos = new Option(kysymys1, "En osaa sanoa");
			oprepo.save(eos);	
			
			
			
			Question kysymys2 = new Question(kysely1, RADIO, "Onko Arskalla hieno auto?");
			qrepo.save(kysymys2);
			Option ei = new Option(kysymys2, "Ei");
			oprepo.save(ei);
			Option on = new Option(kysymys2, "On");
			oprepo.save(on);
			

			QuestionTypeEnum scale = QuestionTypeEnum.SCALE;
			Question kysymys3 = new Question(kysely2, scale, "Mikä fiilis?");
			qrepo.save(kysymys3);

			
		};
	}
}
