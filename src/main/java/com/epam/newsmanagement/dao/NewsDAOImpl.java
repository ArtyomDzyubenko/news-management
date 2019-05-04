package com.epam.newsmanagement.dao;

import com.epam.newsmanagement.entity.News;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class NewsDAOImpl implements NewsDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<News> findAllNews() {
        String hql = "FROM News";

        List<News> newsList = (List<News>) sessionFactory
                .getCurrentSession()
                .createQuery(hql)
                .list();

        if (newsList == null) {
            return new ArrayList<>();
        }

        return newsList;
    }

    @Override
    public List<News> findUserNews(String username) {
        if (username == null) {
            return new ArrayList<>();
        }

        String hql = "FROM News as nws WHERE nws.username = ?1";

        List<News> newsList = (List<News>) sessionFactory
                .getCurrentSession()
                .createQuery(hql)
                .setParameter(1, username)
                .list();

        if (newsList == null) {
            return new ArrayList<>();
        }

        return newsList;
    }

    @Override
    public News findNewsById(Long id) {
        String hql = "FROM News as nws WHERE nws.id = ?1";

        News returned = new News();

        if (id == null) {
            return returned;
        }

        News news = sessionFactory.getCurrentSession().get(News.class, id);

        if (news == null) {
           return returned;
        }

        return news;
    }

    @Override
    public boolean saveNews(News news) {
        if (news == null) {
            return false;
        }

        Long id = (Long) sessionFactory.getCurrentSession().save(news);

        return news.getId().equals(id);
    }

    @Override
    public boolean updateNews(News news) {
        boolean success = true;

        if (news == null) {
            return !success;
        }

        News updated = findNewsById(news.getId());

        if (updated == null) {
            return !success;
        }

        updated.setTitle(news.getTitle());
        updated.setBrief(news.getBrief());
        updated.setContent(news.getContent());

        sessionFactory.getCurrentSession().update(updated);

        return success;
    }

    @Override
    public boolean deleteNewsList(List<Long> IDsList) {
        boolean success = true;

        if (IDsList == null) {
            return !success;
        }

        String hql = "DELETE from News as nws WHERE nws.id = ?1";

        Session session = sessionFactory.getCurrentSession();

        IDsList.forEach(item -> session.createQuery(hql)
                .setParameter(1, item)
                .executeUpdate());

        return success;
    }

    @Override
    public boolean isNewsExist(String title) {
        if (title == null) {
            return false;
        }

        String hql = "FROM News as nws WHERE nws.title = ?1";

        List<News> newsList = (List<News>) sessionFactory.getCurrentSession()
                .createQuery(hql)
                .setParameter(1, title)
                .list();

        return newsList.size() > 0;
    }
}

