package com.dacapo.controller;


import com.dacapo.Entity.Lesson;
import com.dacapo.Entity.LessonContent;
import com.dacapo.service.LessonContentService;
import com.dacapo.service.LessonService;
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
@RequestMapping("/lesson")
public class LessonController {
	
	private static final String STATUS_KEY = "status";

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LessonService lessonService;
    
    @Autowired
    private LessonContentService lessonContentService;


    @RequestMapping(value= "all", method = RequestMethod.GET)
    public Collection<Lesson> getAllLessons() {
        return this.lessonService.getAllLessons();
    }
    
    
    @RequestMapping(value="add", method = RequestMethod.POST)
    public ResponseEntity<Void> createLesson(UriComponentsBuilder b) {

    	
    	Lesson lesson = this.lessonService.createLesson();
    	HttpHeaders headers = new HttpHeaders();
    	
        UriComponents uriComponents = 
                b.path("/{id}").buildAndExpand(lesson.getId());
    	
    	headers.setLocation(uriComponents.toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    	
    }
    
    @RequestMapping(value = "/{id}/content", method = RequestMethod.GET)
    public Collection<LessonContent> getLessonContentById(@PathVariable int id){
    	return this.lessonContentService.getLessonContentByLessonID(id);
    
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Lesson getLessonById(@PathVariable int id) {
        return this.lessonService.getLessonById(id);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Lesson deleteLessonById(@PathVariable int id) {
        return this.lessonService.deleteLessonById(id);
    }


}
