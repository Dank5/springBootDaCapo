package com.dacapo.Entity;

import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.sql.Timestamp;

/**
 * Created by Lewis on 26/04/2017.
 */
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private int id;

    String username;
    String password;
    String email;
    Timestamp createTime;
    int currentLessonId;

    public User(){
        super();
        this.currentLessonId = 1;

    }

    public User(int id) {
        super();
        this.id = id;
    }

    public User(String username, String password, String email) {

        super();
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String email, int id, int currentLessonId) {

        super();
        this.username = username;
        this.password = password;
        this.email = email;
        this.currentLessonId = currentLessonId;


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCurrentLessonId() {
        return currentLessonId;
    }

    public void setCurrentLessonId(int currentLessonId) {
        this.currentLessonId = currentLessonId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

}
