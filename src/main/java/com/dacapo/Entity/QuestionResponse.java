package com.dacapo.Entity;

import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Created by Lewis on 26/04/2017.
 */


public class QuestionResponse extends QuizQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private int id;


    private int questionId;
    private int responseNumber;
    private boolean correctResponse;
    private String responseText;

    public QuestionResponse(){
        super();
        this.id = id;
    }

    public QuestionResponse(int id) {
        this.id = id;
        this.questionId = getQuestionId();
    }

    public QuestionResponse(int id, int questionId, int responseNumber, boolean correctResponse, String responseText) {
        this.id = id;
        this.questionId = questionId;
        this.responseNumber = responseNumber;
        this.correctResponse = correctResponse;
        this.responseText = responseText;
    }


    @Override
    public int getId() {
        return id;
    }

    public int getQuestionId() {
        return super.getId();
    }


    public int getResponseNumber() {
        return responseNumber;
    }

    public void setResponseNumber(int responseNumber) {
        this.responseNumber = responseNumber;
    }

    public boolean isCorrectResponse() {
        return correctResponse;
    }

    public void setCorrectResponse(boolean correctResponse) {
        this.correctResponse = correctResponse;
    }

    public String getResponseText() {
        return responseText;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }
}

