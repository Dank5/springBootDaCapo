package com.dacapo.dao;

import com.dacapo.Entity.LessonContent;

import java.util.Collection;

/**
 * Created by Lewis on 29/04/2017.
 */
public interface LessonContentDao {
    Collection<LessonContent> getAllLessonContents();

    LessonContent createLessonContent();

    void addLessonContent(LessonContent LessonContent);

    void updateLessonContent(LessonContent LessonContent);

    void deleteLessonContent(LessonContent LessonContent);

    LessonContent getLessonContentById(int id);

    LessonContent deleteLessonContentById(int id);

	Collection<LessonContent> getLessonContentByIdLesson(int id);
}
