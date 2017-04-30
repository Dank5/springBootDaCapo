package com.dacapo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dacapo.Entity.Quiz;


@Controller
public class IndexController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String getIndex() {
		return "index";
	}

	@RequestMapping(value="quizform", method=RequestMethod.GET) 
	public String getQuizForm(Quiz quiz){
		return "quizform";
	}
	
}
	
