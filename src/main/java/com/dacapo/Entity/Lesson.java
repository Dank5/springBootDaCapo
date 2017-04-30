package com.dacapo.Entity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.web.bind.annotation.ModelAttribute;


import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Created by Lewis on 26/04/2017.
 */

public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private int id;

    private int lessonContentID;
    private int grade;
    private int number;
    private String category;

    public Lesson() {
        super();
    }

    public Lesson(int id) {
        super();
        this.id = id;
    }

    public Lesson(int grade, int number, int lessonContentID, String category) {
        super();
        this.grade = grade;
        this.lessonContentID = lessonContentID;
        this.number = number;
        this.category = category;
        this.id = getId();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
