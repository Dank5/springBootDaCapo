package com.dacapo.dao;

import com.dacapo.Entity.QuestionResponse;

import java.util.Collection;

/**
 * Created by Lewis on 26/04/2017.
 */
public interface QuestionResponseDao {


    Collection<QuestionResponse> getAllQuestionResponses();

    void addQuestionResponse(QuestionResponse QuestionResponse);

    void updateQuestionResponse(QuestionResponse QuestionResponse);

    void deleteQuestionResponse(QuestionResponse QuestionResponse);

    QuestionResponse getQuestionResponseById(int id);

    QuestionResponse deleteQuestionResponseById(int id);

    QuestionResponse createQuestionResponse();
}

