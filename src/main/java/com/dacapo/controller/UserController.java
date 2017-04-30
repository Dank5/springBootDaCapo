package com.dacapo.controller;

import com.dacapo.Entity.User;
import com.dacapo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by Lewis on 26/04/2017.
 */

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<User> getAllUsers() {
        return this.userService.getAllUsers();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable int id) {
        return this.userService.getUserById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public User deleteUserById(@PathVariable int id) {
        return this.userService.deleteUserById(id);
    }

    @RequestMapping(value = "/{id}/updateLesson", method= RequestMethod.POST)
    public void updateUserLesson(@PathVariable int id, @RequestBody int lessonId) {
        this.userService.updateUserLessonProgress(id, lessonId);
    }
}
