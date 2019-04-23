package com.epam.newsmanagement.dao;

import com.epam.newsmanagement.entity.News;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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

        return newsList;
    }

    @Override
    public List<News> findUserNews(String username) {
        String hql = "FROM News as nws WHERE nws.username = ?1";

        List<News> newsList = (List<News>) sessionFactory
                .getCurrentSession()
                .createQuery(hql)
                .setParameter(1, username)
                .list();

        return newsList;
    }

    @Override
    public News findNewsById(Long id) {
        return sessionFactory.getCurrentSession().get(News.class, id);
    }

    @Override
    public void saveNews(News news) {
        sessionFactory.getCurrentSession().save(news);
    }

    @Override
    public void updateNews(News news) {
        News updated = findNewsById(news.getId());

        updated.setTitle(news.getTitle());
        updated.setBrief(news.getBrief());
        updated.setContent(news.getContent());

        sessionFactory.getCurrentSession().update(updated);
    }

    @Override
    public void deleteNewsList(List<Long> IDsList) {
        String hql = "DELETE from News as nws WHERE nws.id = ?1";

        Session session = sessionFactory.getCurrentSession();

        IDsList.forEach(item -> session.createQuery(hql)
                .setParameter(1, item)
                .executeUpdate());
    }

    @Override
    public boolean isNewsExist(String title) {
        String hql = "FROM News as nws WHERE nws.title = ?1";

        List<News> newsList = (List<News>) sessionFactory.getCurrentSession()
                .createQuery(hql)
                .setParameter(1, title)
                .list();

        return newsList.size() > 0;
    }
}

