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
import com.example.ohjelmistoprojekti1.domain.QuestionType;
import com.example.ohjelmistoprojekti1.domain.QuestionTypeRepository;
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
	public CommandLineRunner demo(SurveyRepository survrepo, QuestionRepository qrepo, QuestionTypeRepository qtrepo, OptionRepository oprepo, AnswerRepository ansrepo, UserRepository urepo) {
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
			
			
			
			
			// kysymystyypit
			QuestionType radio = new QuestionType("radio");
			qtrepo.save(radio);
			QuestionType checkbox = new QuestionType("checkbox");
			qtrepo.save(checkbox);
			QuestionType open = new QuestionType("open");
			qtrepo.save(open);
			QuestionType scale = new QuestionType("scale");
			qtrepo.save(scale);
			
			
			
			Question kysymys1 = new Question(kysely1, radio, "Mitä kuuluu?");
			qrepo.save(kysymys1);
			
			
			Option hyvaa = new Option(kysymys1, "Hyvää");
			oprepo.save(hyvaa);
			Option pahaa = new Option(kysymys1, "Pahaa");
			oprepo.save(pahaa);
			Option eos = new Option(kysymys1, "En osaa sanoa");
			oprepo.save(eos);	
			
			
			
//			Question kysymys2 = new Question(kysely1, radio, "Onko Arskalla hieno auto?");
//			qrepo.save(kysymys2);
//			Option ei = new Option(kysymys2, "Ei");
//			oprepo.save(ei);
//			Option on = new Option(kysymys2, "On");
//			oprepo.save(on);
			
			
			//Answer answer = new Answer(on);
//			ansrepo.save(answer);
			
		};
	}
}
