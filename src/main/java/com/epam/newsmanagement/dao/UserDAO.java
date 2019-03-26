package com.epam.newsmanagement.dao;

import com.epam.newsmanagement.entity.User;

public interface UserDAO {
    User findUserByUsername(String username);
    void saveUser(User user);
}
