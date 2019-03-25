package com.epam.newsmanagement.dao;

import com.epam.newsmanagement.entity.User;
import lombok.extern.log4j.Log4j;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Log4j
@Repository
public class UserDetailsDAOImpl implements UserDetailsDAO {

  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public User findUserByUsername(String username) {
    if (username == null) {
         log.error("Null input in findUserByUsername()");
         return new User();
    }

    return sessionFactory.getCurrentSession().get(User.class, username);
  }
}
