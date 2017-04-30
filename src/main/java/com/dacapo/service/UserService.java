package com.dacapo.service;

import com.dacapo.Entity.User;
import com.dacapo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Lewis on 26/04/2017.
 */
@Service
public class UserService {

    @Autowired
    @Qualifier("mysql-user")
    private UserDao userDao;

    public Collection<User> getAllUsers() {
        return this.userDao.getAllUsers();
    }

    public void addUser(User user) {

    }

    public void updateUser(User user) {

    }

    public void deleteUser(User user) {

    }

    public User getUserById(int id) {
        return this.userDao.getUserById(id);
    }

    public User deleteUserById(int id) {
        return this.userDao.deleteUserById(id);
    }

    public void updateUserLessonProgress(int id, int lessonId) {
        userDao.updateUserLessonProgress(id, lessonId);
    }
}
