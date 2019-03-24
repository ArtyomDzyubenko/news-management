package com.epam.newsmanagement.dao;

import com.epam.newsmanagement.entity.User;

public interface UserDetailsDAO {
  User findUserByUsername(String username);
}
