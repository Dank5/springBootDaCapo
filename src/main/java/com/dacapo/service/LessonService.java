package com.dacapo.service;

import com.dacapo.Entity.Lesson;
import com.dacapo.dao.LessonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Lewis on 26/04/2017.
 */
@Service
public class LessonService {

    @Autowired
    @Qualifier("mysql-lesson")
    private LessonDao lessonDao;

    public Collection<Lesson> getAllLessons() {
        return this.lessonDao.getAllLessons();
    }

    public void addLesson(Lesson lesson) {
            this.lessonDao.addLesson(lesson);
    }

    public void updateLesson(Lesson lesson) {
            this.lessonDao.updateLesson(lesson);
    }

    public void deleteLesson(Lesson lesson) {
            this.lessonDao.deleteLesson(lesson);
    }

    public Lesson getLessonById(int id) {
        return this.lessonDao.getLessonById(id);
    }

    public Lesson deleteLessonById(int id) {
        return this.lessonDao.deleteLessonById(id);
    }
    
    public Lesson createLesson(){
    	return this.lessonDao.createLesson();
    }
}
