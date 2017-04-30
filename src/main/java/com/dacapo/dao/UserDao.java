package com.dacapo.dao;

import java.util.Collection;

import com.dacapo.Entity.User;

public interface UserDao {

    Collection<User> getAllUsers();

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(User user);

    void updateUserLessonProgress(int userId, int lessonId);

    User getUserById(int id);

    User deleteUserById(int id);

}
