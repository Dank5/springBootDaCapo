package com.dacapo.dao.implicit;


import com.dacapo.Entity.User;
import com.dacapo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Lewis on 26/04/2017.
 */
@Repository("mysql-user")
public class MysqlUserDao implements UserDao {

    @Autowired
    JdbcTemplate jdbc;

    private class UserRowMapper implements RowMapper<User> {

        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            user.setCreateTime(resultSet.getTimestamp("create_time"));
            user.setCurrentLessonId(resultSet.getInt("lesson_number"));
            return user;

        }
    }

    @Override
    public Collection<User> getAllUsers() {
        final String sql = "SELECT id, username, password, create_time, lesson_number  FROM user";
        return jdbc.query(sql, new UserRowMapper());
    }

    @Override
    public void addUser(User user) {
        final String sql = "INSERT into user (username, password, email, create_time) values (?,?,?,NOW());";
        String username= user.getUsername();
        String password = user.getPassword();
        String email = user.getEmail() ;
        jdbc.update(sql,  new Object[]{username, password, email});
        // jdbc.query(sql);
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public void updateUserLessonProgress(int userId, int lessonId) {
        final String sql = "UPDATE user SET lessonId = ? where id = ?";
        jdbc.queryForObject(sql,new UserRowMapper(), new Object[]{lessonId, userId});
    }

    @Override
    public User getUserById(int id) {
        final String sql = "SELECT id, username, password FROM user where id = ?";
        return jdbc.queryForObject(sql,new UserRowMapper(), id);
    }

    @Override
    public User deleteUserById(int id) {
        final String sql = "DELETE user FROM user where id = ?";
        return jdbc.queryForObject(sql,new UserRowMapper(), id);
    }
}
