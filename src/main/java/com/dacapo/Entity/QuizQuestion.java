package com.dacapo.Entity;

import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Created by Lewis on 26/04/2017.
 */
public class QuizQuestion extends Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private int id;
    private int quizId;
    private int number;
    private String questionText;
    //  private Quiz quiz;

    public QuizQuestion() {
        super();
        //  quiz = new Quiz(getQuizId());
    }


    @Override
    public int getId() {
        return id;
    }


    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void setNumber(int number) {
        this.number = number;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = super.getId();
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    // public Quiz getQuiz() {
    //    return quiz;
    //

    // public void setQuiz(Quiz quiz) {
    //     this.quiz = quiz;
    // }
}

