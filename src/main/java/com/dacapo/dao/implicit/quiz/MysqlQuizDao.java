package com.dacapo.dao.implicit.quiz;

import com.dacapo.Entity.Lesson;
import com.dacapo.Entity.Quiz;
import com.dacapo.dao.QuizDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Lewis on 26/04/2017.
 */
@Repository("mysql-quiz")
public class MysqlQuizDao implements QuizDao {

    @Autowired
    JdbcTemplate jdbc;

    private class QuizRowMapper implements RowMapper<Quiz> {

        public Quiz mapRow(ResultSet resultSet, int i) throws SQLException {
            Quiz Quiz = new Quiz();
            Quiz.setGrade(resultSet.getInt("grade"));
            Quiz.setNumber(resultSet.getInt("number"));
            Quiz.setCategory(resultSet.getString("category"));
            return Quiz;

        }
    }

    @Override
    public Collection<Quiz> getAllQuizs() {
        final String sql = "SELECT id, grade, number, category FROM quiz";
        return jdbc.query(sql, new QuizRowMapper());
    }

    @Override
    public Quiz createQuiz() {
    	final Quiz quiz = new Quiz();
    	final String sql = "insert into Quiz (grade, number, category) values (?, ?, ?)";
        int grade = 0;
        int number = 0;
        String category = "";
        jdbc.update(sql, new Object[]{grade, number, category});
        System.out.println(quiz.getId());
		return quiz;
    	
    }

    @Override
    public void addQuiz(Quiz Quiz) {    
    	final String sql = "insert into Quiz (grade, number, category) values (?, ?, ?)";
        int grade = Quiz.getGrade();
        int number = Quiz.getNumber();
        String category = Quiz.getCategory();
        jdbc.update(sql, new Object[]{grade, number, category});
    }
    
    

    @Override
    public void updateQuiz(Quiz Quiz) {

    }

    @Override
    public void deleteQuiz(Quiz Quiz) {

    }

    @Override
    public Quiz getQuizById(int id) {
        final String sql = "SELECT id, grade, number, category FROM quiz where id = ?";
        return jdbc.queryForObject(sql,new QuizRowMapper(), id);
    }

    @Override
    public Quiz deleteQuizById(int id) {
        final String sql = "DELETE quiz FROM quiz where id = ?";
        return jdbc.queryForObject(sql,new QuizRowMapper(), id);
    }

}
