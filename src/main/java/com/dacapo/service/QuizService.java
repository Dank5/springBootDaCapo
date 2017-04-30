package com.dacapo.service;

import com.dacapo.Entity.Quiz;
import com.dacapo.dao.QuizDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Lewis on 26/04/2017.
 */
@Service
public class QuizService {

    @Autowired
    @Qualifier("mysql-quiz")
    private QuizDao quizDao;

    public Collection<Quiz> getAllQuizs() {
        return this.quizDao.getAllQuizs();
    }

    public void addQuiz(Quiz quiz) {
        this.quizDao.addQuiz(quiz);
    }

    public void updateQuiz(Quiz quiz) {
        this.quizDao.updateQuiz(quiz);
    }

    public void deleteQuiz(Quiz quiz) {
        this.quizDao.deleteQuiz(quiz);
    }

    public Quiz getQuizById(int id) {
        return this.quizDao.getQuizById(id);
    }

    public Quiz deleteQuizById(int id) {
        return this.quizDao.deleteQuizById(id);
    }

    public Quiz createQuiz(){
        return this.quizDao.createQuiz();
    }

}
