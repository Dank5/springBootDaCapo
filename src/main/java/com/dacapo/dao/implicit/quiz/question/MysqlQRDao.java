package com.dacapo.dao.implicit.quiz.question;

import com.dacapo.Entity.QuestionResponse;
import com.dacapo.Entity.QuestionResponse;
import com.dacapo.dao.QuestionResponseDao;
import com.dacapo.dao.QuestionResponseDao;
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
@Qualifier("mysql-question-response")
public class MysqlQRDao implements QuestionResponseDao {

    @Autowired
    JdbcTemplate jdbc;

    private class QuestionResponseRowMapper implements RowMapper<QuestionResponse> {

        public QuestionResponse mapRow(ResultSet resultSet, int i) throws SQLException {
            QuestionResponse QuestionResponse = new QuestionResponse();
            QuestionResponse.setQuestionId(resultSet.getInt("question_id"));
            QuestionResponse.setResponseNumber(resultSet.getInt("response_number"));
            QuestionResponse.setCorrectResponse(resultSet.getBoolean("correct_response"));
            QuestionResponse.setResponseText(resultSet.getString("response_text"));
            return QuestionResponse;

        }
    }

    @Override
    public Collection<QuestionResponse> getAllQuestionResponses() {
        final String sql = "SELECT id, question_id, response_number, correct_response, response_text FROM question_response";
        return jdbc.query(sql, new QuestionResponseRowMapper());
    }

    @Override
    public void addQuestionResponse(QuestionResponse QuestionResponse) {
        final String sql = "insert into question_response (question_id, response_number, correct_response, response_text) values (" + QuestionResponse.getQuestionId() + ","+ QuestionResponse.getResponseNumber() + ","+ QuestionResponse.isCorrectResponse()+ ","+ QuestionResponse.getResponseText() + ";";
        // jdbc.query(sql);
    }

    @Override
    public void updateQuestionResponse(QuestionResponse QuestionResponse) {

    }

    @Override
    public void deleteQuestionResponse(QuestionResponse QuestionResponse) {

    }

    @Override
    public QuestionResponse getQuestionResponseById(int id) {
        final String sql = "SELECT id, question_id,  response_number, correct_response, response_text FROM question_response where id = ?";
        return jdbc.queryForObject(sql,new QuestionResponseRowMapper(), id);
    }

    @Override
    public QuestionResponse deleteQuestionResponseById(int id) {
        final String sql = "DELETE question_response FROM question_response where id = ?";
        return jdbc.queryForObject(sql,new QuestionResponseRowMapper(), id);
    }

    @Override
    public QuestionResponse createQuestionResponse() {
            final QuestionResponse questionResponse = new QuestionResponse();
            final String sql = "insert into question_response (question_id,  response_number, correct_response, response_text) values (?, ?, ?)";
            int question_id = 1;
            int response_number = 0;
            boolean correct_response = true;
            String response_text = "";

            jdbc.update(sql, new Object[]{question_id, response_number, correct_response, response_text});
            System.out.println(questionResponse.getId());
            return questionResponse;
        }
}
