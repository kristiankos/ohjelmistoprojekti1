package com.example.ohjelmistoprojekti1.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ohjelmistoprojekti1.domain.Option;
import com.example.ohjelmistoprojekti1.domain.OptionRepository;

@RestController
@RequestMapping("/options")
public class OptionController {

	@Autowired
	private OptionRepository oprepo;
	
	@GetMapping
	public List<Option> optionListResti(){
		return (List<Option>) oprepo.findAll();
	}
	
	@PostMapping
	public @ResponseBody Option saveOptionRest(@RequestBody Option option) {
		return oprepo.save(option);
	}
}
