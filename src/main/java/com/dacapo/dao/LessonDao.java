package com.dacapo.dao;

import com.dacapo.Entity.Lesson;

import java.util.Collection;

/**
 * Created by Lewis on 26/04/2017.
 */
public interface LessonDao {

        Collection<Lesson> getAllLessons();

        void addLesson(Lesson lesson);

        void updateLesson(Lesson Lesson);

        void deleteLesson(Lesson Lesson);

        Lesson getLessonById(int id);

        Lesson deleteLessonById(int id);

		Lesson createLesson();

    }
