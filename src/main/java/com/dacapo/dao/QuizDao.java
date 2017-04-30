package com.dacapo.dao;

import com.dacapo.Entity.Lesson;
import com.dacapo.Entity.Quiz;

import java.util.Collection;

/**
 * Created by Lewis on 26/04/2017.
 */
public interface QuizDao {

    Collection<Quiz> getAllQuizs();

    void addQuiz(Quiz Quiz);

    void updateQuiz(Quiz Quiz);

    void deleteQuiz(Quiz Quiz);

    Quiz getQuizById(int id);

    Quiz deleteQuizById(int id);

	Quiz createQuiz();

}
