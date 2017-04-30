package com.dacapo.service;

import com.dacapo.Entity.LessonContent;
import com.dacapo.dao.LessonContentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Lewis on 26/04/2017.
 */
@Service
public class LessonContentService {

    @Autowired
    @Qualifier("mysql-lesson-content")
    private LessonContentDao lessonContentDao;

    public Collection<LessonContent> getAllLessonContents() {
        return this.lessonContentDao.getAllLessonContents();
    }

    public void addLessonContent(LessonContent lesson) {
        this.lessonContentDao.addLessonContent(lesson);
    }

    public void updateLessonContent(LessonContent lesson) {
        this.lessonContentDao.updateLessonContent(lesson);
    }

    public void deleteLessonContent(LessonContent lesson) {
        this.lessonContentDao.deleteLessonContent(lesson);
    }

    public LessonContent getLessonContentById(int id) {
        return this.lessonContentDao.getLessonContentById(id);
    }

    public LessonContent deleteLessonContentById(int id) {
        return this.lessonContentDao.deleteLessonContentById(id);
    }

    public LessonContent createLessonContent(){
        return this.lessonContentDao.createLessonContent();
    }

	public Collection<LessonContent> getLessonContentByLessonID(int id) {
		return this.lessonContentDao.getLessonContentByIdLesson(id);
	}
}
