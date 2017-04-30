package com.dacapo.dao.implicit.quiz.question;

import com.dacapo.Entity.QuizQuestion;
import com.dacapo.dao.QuizQuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Lewis on 26/04/2017.
 */
@Component
@Qualifier("mysql-quiz-question")
public class MysqlQuizQuestionDao implements QuizQuestionDao {

    @Autowired
    JdbcTemplate jdbc;

    private class QuizQuestionRowMapper implements RowMapper<QuizQuestion> {

        public QuizQuestion mapRow(ResultSet resultSet, int i) throws SQLException {
            QuizQuestion QuizQuestion = new QuizQuestion();
            QuizQuestion.setQuizId(resultSet.getInt("quiz_id"));
            QuizQuestion.setNumber(resultSet.getInt("number"));
            QuizQuestion.setQuestionText(resultSet.getString("question_text"));
            return QuizQuestion;

        }
    }

    @Override
    public Collection<QuizQuestion> getAllQuizQuestions() {
        final String sql = "SELECT id, quiz_id, number, question_text FROM quiz_question";
        return jdbc.query(sql, new QuizQuestionRowMapper());
    }

    @Override
    public void addQuizQuestion(QuizQuestion QuizQuestion) {
        final String sql = "insert into quiz_question (quiz_id, number, question_text) values (" + QuizQuestion.getQuizId() + ","+ QuizQuestion.getNumber() + ","+ QuizQuestion.getQuestionText() + ";";
        // jdbc.query(sql);
    }

    @Override
    public void updateQuizQuestion(QuizQuestion QuizQuestion) {

    }

    @Override
    public void deleteQuizQuestion(QuizQuestion QuizQuestion) {

    }

    @Override
    public QuizQuestion getQuizQuestionById(int id) {
        final String sql = "SELECT id, quiz_id, number, question_text FROM quiz_question where id = ?";
        return jdbc.queryForObject(sql,new QuizQuestionRowMapper(), id);
    }

    @Override
    public QuizQuestion deleteQuizQuestionById(int id) {
        final String sql = "DELETE quiz_question FROM quiz_question where id = ?";
        return jdbc.queryForObject(sql,new QuizQuestionRowMapper(), id);
    }

    @Override
    public QuizQuestion createQuizQuestion() {
        final QuizQuestion quiz = new QuizQuestion();
        final String sql = "insert into quiz_question (grade, number, category) values (?, ?, ?)";
        int grade = 0;
        int number = 0;
        String category = "";
        jdbc.update(sql, new Object[]{grade, number, category});
        System.out.println(quiz.getId());
        return quiz;
    }

    @Override
    public Collection<QuizQuestion> getQuizQuestionByQuestionId(int id) {
        final String sql = "SELECT * FROM quiz_question where lesson_id = ?";

        return jdbc.query(sql, new QuizQuestionRowMapper(), id);
    }
}
