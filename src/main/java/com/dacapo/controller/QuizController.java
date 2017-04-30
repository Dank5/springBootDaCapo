package com.dacapo.controller;


import com.dacapo.Entity.LessonContent;
import com.dacapo.Entity.Quiz;
import com.dacapo.Entity.QuizQuestion;
import com.dacapo.service.QuizQuestionService;
import com.dacapo.service.QuizService;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Collection;

/**
 * Created by Lewis on 26/04/2017.
 */
@RestController
@RequestMapping("/quiz")
public class QuizController {
	
	private static final String STATUS_KEY = "status";

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private QuizService quizService;
    
    @Autowired
    private QuizQuestionService quizQuestionService;



    @RequestMapping(value= "all", method = RequestMethod.GET)
    public Collection<Quiz> getAllQuizs() {
        return this.quizService.getAllQuizs();
    }
    
/*    @RequestMapping(method = RequestMethod.GET)
    public Quiz getQuiz() {
    	Quiz quiz = this.quizService.createQuiz();
    	return quiz;
    }*/


    @RequestMapping(value="new", method = RequestMethod.POST)
    public void createQuiz(@ModelAttribute Quiz quiz, UriComponentsBuilder b) {
    	this.quizService.addQuiz(quiz);
    }

    @RequestMapping(value = "/{id}/questions", method = RequestMethod.GET)
    public Collection<QuizQuestion> getQuizQuestionsById(@PathVariable int id){
    	return this.quizQuestionService.getQuizQuestionsByQuestionId(id);

    }


    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Quiz getQuizById(@PathVariable int id) {
        return this.quizService.getQuizById(id);
    }


    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public Quiz deleteQuizById(@PathVariable int id) {
        return this.quizService.deleteQuizById(id);
    }
    
    


}
