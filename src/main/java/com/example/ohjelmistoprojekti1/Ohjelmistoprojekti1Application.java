package com.example.ohjelmistoprojekti1;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.example.ohjelmistoprojekti1.domain.Answer;
import com.example.ohjelmistoprojekti1.domain.AnswerRepository;
import com.example.ohjelmistoprojekti1.domain.AnsweredSurvey;
import com.example.ohjelmistoprojekti1.domain.AnsweredSurveyRepository;
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
	public CommandLineRunner demo(SurveyRepository survrepo, QuestionRepository qrepo, OptionRepository oprepo, AnswerRepository ansrepo, UserRepository urepo, AnsweredSurveyRepository anssurrepo) {
		return (args) -> {
			log.info("saving");
			//Luodaan admin käyttäjä
			User admin = new User("admin","$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C","ADMIN");
			urepo.save(admin);
			
			// Pari esimerkki kyselyä
			Survey kysely1 = new Survey("Kyselyn1 otsikko");
			survrepo.save(kysely1);
			
			Question kysymys1 = new Question(kysely1, QuestionTypeEnum.RADIO, null, "Mitä kuuluu?");
			qrepo.save(kysymys1);
			
			
			Option hyvaa = new Option(kysymys1, "Hyvää");
			oprepo.save(hyvaa);
			Option pahaa = new Option(kysymys1, "Pahaa");
			oprepo.save(pahaa);
			Option eos = new Option(kysymys1, "En osaa sanoa");
			oprepo.save(eos);	
			
			
			
			Question kysymys2 = new Question(kysely1, QuestionTypeEnum.RADIO, null, "Onko Arskalla hieno auto?");
			qrepo.save(kysymys2);
			Option ei = new Option(kysymys2, "Ei");
			oprepo.save(ei);
			Option on = new Option(kysymys2, "On");
			oprepo.save(on);
			
			
			
			
			Survey kysely2 = new Survey("Kyselyn2 otsikko");
			survrepo.save(kysely2);
			
			Question kys3 = new Question(kysely2, QuestionTypeEnum.OPENTEXT, null, "Miten menee?");
			qrepo.save(kys3);
			
			Question kys4 = new Question(kysely2, QuestionTypeEnum.OPENTEXT, null, "Mitä kuuluu?");
			qrepo.save(kys4);
			

			
			
			Survey kysely3 = new Survey("Kyselyn3 otsikko");
			survrepo.save(kysely3);
			
			Question kys5 = new Question(kysely3, QuestionTypeEnum.SCALE, null, "Mikä fiilis?");
			qrepo.save(kys5);
			
			Question kys6 = new Question(kysely3, QuestionTypeEnum.SCALE, null, "Fiilis ykkösestä viiteen?");
			qrepo.save(kys6);
			
			
			
			
			Survey kysely4 = new Survey("Kyselyn4 otsikko");
			survrepo.save(kysely4);
			
			Question kys7 = new Question(kysely4, QuestionTypeEnum.CHECKBOX, null, "Mitä näistä tykkäät tehdä?");
			qrepo.save(kys7);
			Option ajaa = new Option(kys7, "Ajaa autoa");
			oprepo.save(ajaa);
			Option pyora = new Option(kys7, "Ajaa autoa");
			oprepo.save(pyora);
			
			
			
			
			Survey kysely5 = new Survey("Kyselyn 5 otsikko");
			survrepo.save(kysely5);
			
			Question kys8 = new Question(kysely5, QuestionTypeEnum.RADIO, null, "Mikä näistä on lempiväri?");
			qrepo.save(kys8);
			Option musta = new Option(kys8, "Musta");
			oprepo.save(musta);
			Option valk = new Option(kys8, "Valkoinen");
			oprepo.save(valk);
			Option pun = new Option(kys8, "Punainen");
			oprepo.save(pun);
			
			Question kys9 = new Question(kysely5, QuestionTypeEnum.OPENTEXT, null, "Missä kaupungissa asut?");
			qrepo.save(kys9);
			
			Question kys10 = new Question(kysely5, QuestionTypeEnum.SCALE, null, "Suositteletko muille (1-5)?");
			qrepo.save(kys10);
			
			Question kys11 = new Question(kysely5, QuestionTypeEnum.CHECKBOX, null, "Mihin voisit muuttaa?");
			qrepo.save(kys11);
			Option hel = new Option(kys11, "Helsinki");
			oprepo.save(hel);
			Option van = new Option(kys11, "Vantaa");
			oprepo.save(van);
			Option esp = new Option(kys11, "Espoo");
			oprepo.save(esp);
			
			
			
			Answer ans = new Answer((long) 20, "Musta");
			ansrepo.save(ans);
			Answer ans1 = new Answer((long) 24, "Helsinki");
			ansrepo.save(ans1);
			Answer ans2 = new Answer((long) 25, "1");
			ansrepo.save(ans2);
			Answer ans3 = new Answer((long) 26, "Espoo");
			ansrepo.save(ans3);

			ArrayList<Answer> anslist = new ArrayList<Answer>();
			anslist.add(ans);
			anslist.add(ans1);
			anslist.add(ans2);
			anslist.add(ans3);

			
			AnsweredSurvey anssur = new AnsweredSurvey((long) 19, anslist);
			anssurrepo.save(anssur);
			
			
			
			Answer ans4 = new Answer((long) 20, "Punainen");
			ansrepo.save(ans4);
			Answer ans11 = new Answer((long) 24, "Tampere");
			ansrepo.save(ans11);
			Answer ans22 = new Answer((long) 25, "5");
			ansrepo.save(ans22);
			Answer ans331 = new Answer((long) 26, "Helsinki");
			ansrepo.save(ans331);
			Answer ans332 = new Answer((long) 26, "Vantaa");
			ansrepo.save(ans332);
			Answer ans334 = new Answer((long) 26, "Espoo");
			ansrepo.save(ans334);

			ArrayList<Answer> anslist1 = new ArrayList<Answer>();
			anslist1.add(ans4);
			anslist1.add(ans11);
			anslist1.add(ans22);
			anslist1.add(ans331);
			anslist1.add(ans332);
			anslist1.add(ans334);

			
			AnsweredSurvey anssur1 = new AnsweredSurvey((long) 19, anslist1);
			anssurrepo.save(anssur1);
			
			
			
			Answer ans44 = new Answer((long) 20, "Valkoinen");
			ansrepo.save(ans44);
			Answer ans111 = new Answer((long) 24, "Turku");
			ansrepo.save(ans111);
			Answer ans222 = new Answer((long) 25, "2");
			ansrepo.save(ans222);
			Answer ans333 = new Answer((long) 26, "Helsinki");
			ansrepo.save(ans333);

			ArrayList<Answer> anslist11 = new ArrayList<Answer>();
			anslist11.add(ans44);
			anslist11.add(ans111);
			anslist11.add(ans222);
			anslist11.add(ans333);

			
			AnsweredSurvey anssur11 = new AnsweredSurvey((long) 19, anslist11);
			anssurrepo.save(anssur11);

			
		};
	}
}
