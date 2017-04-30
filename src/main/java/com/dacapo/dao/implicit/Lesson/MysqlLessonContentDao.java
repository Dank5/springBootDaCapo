package com.dacapo.dao.implicit.Lesson;

import com.dacapo.Entity.LessonContent;
import com.dacapo.Entity.LessonContent;
import com.dacapo.dao.LessonContentDao;
import com.dacapo.dao.LessonContentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import org.springframework.jdbc.core.RowMapper;

import com.dacapo.Entity.LessonContent;

    

    /**
     * Created by Lewis on 26/04/2017.
     */
    @Repository("mysql-lesson-content")
    public class MysqlLessonContentDao implements LessonContentDao {
        

            @Autowired
            JdbcTemplate jdbc;

            private class LessonContentRowMapper implements RowMapper<LessonContent> {
            	
            	public LessonContent mapRow(ResultSet resultSet, int i) throws SQLException {
            		LessonContent LessonContent = new LessonContent();
            		LessonContent.setLessonId(resultSet.getInt("lessonId"));
            		LessonContent.setContentType(resultSet.getString("contentType"));
            		LessonContent.setContentSequence(resultSet.getInt("contentSequence"));
            		LessonContent.setContentText(resultSet.getString("contentText"));
        			return LessonContent;
            	}
            }
            

            @Override
            public Collection<LessonContent> getAllLessonContents() {
                final String sql = "SELECT id, lessonId,  contentType, contentSequence, contentText FROM lesson_content";
                return jdbc.query(sql, new LessonContentRowMapper());
            }
            
            @Override
            public LessonContent createLessonContent() {
            	final LessonContent lesson = new LessonContent();
            	final String sql = "insert into Lesson_content (lessonId, contentType, contentSequence, contentText) values (?, ?, ?, ?)";
            	int lessonId = 0;
                String contentType = "";
                int contentSequence = 0;
                String contentText = "";
                jdbc.update(sql, new Object[]{lessonId, contentType, contentSequence, contentText });
                System.out.println(lesson.getId());
    			return lesson;
            	
            }

            @Override
            public void addLessonContent(LessonContent LessonContent) {
                final String sql = "insert into Lesson_content (lessonId, contentType, contentSequence, contentText) values (?, ?, ?, ?);";
                // jdbc.query(sql);
                int lessonId = LessonContent.getLessonId();
                String contentType = LessonContent.getContentType();
                int contentSequence = LessonContent.getContentSequence();
                String contentText = LessonContent.getContentText();
                jdbc.update(sql, new Object[]{lessonId, contentType, contentSequence, contentText});
                final int id = LessonContent.getId();
            }

            @Override
            public void updateLessonContent(LessonContent LessonContent) {

            }

            @Override
            public void deleteLessonContent(LessonContent LessonContent) {

            }
            

            @Override
            public LessonContent getLessonContentById(int id) {
                final String sql = "SELECT id, lessonId, contentType, contentSequence, contentText FROM lesson_content where id = ?";
                return jdbc.queryForObject(sql,new LessonContentRowMapper(), id);
            }

            @Override
            public LessonContent deleteLessonContentById(int id) {
                final String sql = "DELETE lesson_content FROM lesson_content where id = ?";
                return jdbc.queryForObject(sql,new LessonContentRowMapper(), id);
            }

			@Override
			public Collection<LessonContent> getLessonContentByIdLesson(int id) {
				final String sql = "SELECT * FROM lesson_content where lesson_id = ?";
				
				return jdbc.query(sql, new LessonContentRowMapper(), id);
			}
            

}

