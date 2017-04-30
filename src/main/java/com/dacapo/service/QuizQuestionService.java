package com.dacapo.service;

import com.dacapo.Entity.QuizQuestion;
import com.dacapo.dao.QuizQuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Lewis on 26/04/2017.
 */
@Service
public class QuizQuestionService {

    @Autowired
    @Qualifier("mysql-quiz-question")
    private QuizQuestionDao quizQuestionDao;

    public Collection<QuizQuestion> getAllQuizQuestions() {
        return this.quizQuestionDao.getAllQuizQuestions();
    }

    public void addQuizQuestion(QuizQuestion quizQuestionService) {
        this.quizQuestionDao.addQuizQuestion(quizQuestionService);
    }

    public void updateQuizQuestion(QuizQuestion quizQuestionService) {
        this.quizQuestionDao.updateQuizQuestion(quizQuestionService);
    }

    public void deleteQuizQuestion(QuizQuestion quizQuestionService) {
        this.quizQuestionDao.deleteQuizQuestion(quizQuestionService);
    }

    public QuizQuestion getQuizQuestionById(int id) {
        return this.quizQuestionDao.getQuizQuestionById(id);
    }

    public QuizQuestion deleteQuizQuestionById(int id) {
        return this.quizQuestionDao.deleteQuizQuestionById(id);
    }

    public QuizQuestion createQuizQuestion(){
        return this.quizQuestionDao.createQuizQuestion();
    }

    public Collection<QuizQuestion> getQuizQuestionsByQuestionId(int id) {
        return this.quizQuestionDao.getQuizQuestionByQuestionId(id);
    }
}
