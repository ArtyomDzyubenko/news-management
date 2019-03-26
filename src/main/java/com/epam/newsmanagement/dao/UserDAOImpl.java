package com.epam.newsmanagement.dao;

import com.epam.newsmanagement.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User findUserByUsername(String username) {
        return sessionFactory.getCurrentSession().get(User.class, username);
    }

    public void saveUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }
}
