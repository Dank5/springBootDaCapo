package com.dacapo.service;

import com.dacapo.Entity.QuestionResponse;
import com.dacapo.dao.QuestionResponseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Lewis on 26/04/2017.
 */
@Service
public class QuestionResponseService {

    @Autowired
    @Qualifier("mysql-question-response")
    private QuestionResponseDao questionResponseDao;

    public Collection<QuestionResponse> getAllQuestionResponses() {
        return this.questionResponseDao.getAllQuestionResponses();
    }

    public void addQuestionResponse(QuestionResponse questionResponseService) {
        this.questionResponseDao.addQuestionResponse(questionResponseService);
    }

    public void updateQuestionResponse(QuestionResponse questionResponseService) {
        this.questionResponseDao.updateQuestionResponse(questionResponseService);
    }

    public void deleteQuestionResponse(QuestionResponse questionResponseService) {
        this.questionResponseDao.deleteQuestionResponse(questionResponseService);
    }

    public QuestionResponse getQuestionResponseById(int id) {
        return this.questionResponseDao.getQuestionResponseById(id);
    }

    public QuestionResponse deleteQuestionResponseById(int id) {
        return this.questionResponseDao.deleteQuestionResponseById(id);
    }

    public QuestionResponse createQuestionResponse(){
        return this.questionResponseDao.createQuestionResponse();
    }
}
