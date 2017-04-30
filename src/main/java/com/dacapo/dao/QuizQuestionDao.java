package com.dacapo.dao;

import com.dacapo.Entity.QuizQuestion;

import java.util.Collection;

/**
 * Created by Lewis on 26/04/2017.
 */
public interface QuizQuestionDao {

    Collection<QuizQuestion> getAllQuizQuestions();

    void addQuizQuestion(QuizQuestion QuizQuestion);

    void updateQuizQuestion(QuizQuestion QuizQuestion);

    void deleteQuizQuestion(QuizQuestion QuizQuestion);

    QuizQuestion getQuizQuestionById(int id);

    QuizQuestion deleteQuizQuestionById(int id);

    QuizQuestion createQuizQuestion();

    Collection<QuizQuestion> getQuizQuestionByQuestionId(int id);
}
