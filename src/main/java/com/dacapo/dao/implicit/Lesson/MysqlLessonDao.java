package com.dacapo.dao.implicit.Lesson;

import com.dacapo.Entity.Lesson;
import com.dacapo.Entity.LessonContent;
import com.dacapo.dao.LessonDao;
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
@Repository("mysql-lesson")
public class MysqlLessonDao implements LessonDao {
    

        @Autowired
        JdbcTemplate jdbc;

        private class LessonRowMapper implements RowMapper<Lesson> {

            public Lesson mapRow(ResultSet resultSet, int i) throws SQLException {
                Lesson Lesson = new Lesson();
                Lesson.setGrade(resultSet.getInt("grade"));
                Lesson.setNumber(resultSet.getInt("number"));
                Lesson.setCategory(resultSet.getString("category"));
                return Lesson;

            }
        }
        

        @Override
        public Collection<Lesson> getAllLessons() {
            final String sql = "SELECT id, grade, number, category FROM lesson";
            return jdbc.query(sql, new LessonRowMapper());
        }
        
        @Override
        public Lesson createLesson() {
        	final Lesson lesson = new Lesson();
        	final String sql = "insert into Lesson (grade, number, category) values (?, ?, ?)";
            int grade = 0;
            int number = 0;
            String category = "";
            jdbc.update(sql, new Object[]{grade, number, category});
            System.out.println(lesson.getId());
			return lesson;
        	
        }

        @Override
        public void addLesson(Lesson Lesson) {
            final String sql = "insert into Lesson (grade, number, category) values (?, ?, ?);";
            // jdbc.query(sql);
            int grade = Lesson.getGrade();
            int number = Lesson.getNumber();
            String category = Lesson.getCategory();
            jdbc.update(sql, new Object[]{grade, number, category});
            final int id = Lesson.getId();
        }

        @Override
        public void updateLesson(Lesson Lesson) {

        }

        @Override
        public void deleteLesson(Lesson Lesson) {

        }
        

        @Override
        public Lesson getLessonById(int id) {
            final String sql = "SELECT id, grade, number, category FROM lesson where id = ?";
            return jdbc.queryForObject(sql,new LessonRowMapper(), id);
        }

        @Override
        public Lesson deleteLessonById(int id) {
            final String sql = "DELETE lesson FROM lesson where id = ?";
            return jdbc.queryForObject(sql,new LessonRowMapper(), id);
        }
        

    }