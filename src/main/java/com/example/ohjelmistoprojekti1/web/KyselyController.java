package com.example.ohjelmistoprojekti1.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.ohjelmistoprojekti1.domain.Kysely;
import com.example.ohjelmistoprojekti1.domain.KyselyRepository;

@Controller
public class KyselyController {

	private KyselyRepository kyselyrepo;
	
	public @ResponseBody List<Kysely> getKysely() {
		return (List<Kysely>) kyselyrepo.findAll();
	}
}
