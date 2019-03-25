package com.epam.newsmanagement.dao;

import com.epam.newsmanagement.entity.News;
import lombok.extern.log4j.Log4j;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Log4j
@Repository
public class NewsDAOImpl implements NewsDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<News> findAllNews() {
        String hql = "FROM News";

        List<News> newsList = (List<News>) sessionFactory
                .openSession()
                .createQuery(hql)
                .list();

        if (newsList == null) {
            log.error("Null output in findAllNews()");
            return new ArrayList<>();
        }

        return newsList;
    }

    @Override
    public News findNewsById(Long id) {
        if (id == null) {
            log.error("Null input in findNewsById()");
            return new News();
        }

        return sessionFactory.openSession().get(News.class, id);
    }

    @Override
    public void saveNews(News news) {
        if (news == null) {
            log.error("Null input in saveNews()");
            return;
        }

        sessionFactory.getCurrentSession().save(news);
    }

    @Override
    public void updateNews(News news) {
        if (news == null) {
            log.error("Null input in updateNews()");
            return;
        }

        News updated = findNewsById(news.getId());

        updated.setTitle(news.getTitle());
        updated.setBrief(news.getBrief());
        updated.setContent(news.getContent());

        sessionFactory.getCurrentSession().update(updated);
    }

    @Override
    public void deleteNewsList(List<Long> IDsList) {
        if (IDsList == null) {
            log.error("Null input in deleteNewsList()");
            return;
        }

        String hql = "DELETE from News as nws WHERE nws.id = ?1";

        for (Long item: IDsList) {
            sessionFactory.getCurrentSession()
                    .createQuery(hql)
                    .setParameter(1, item)
                    .executeUpdate();
        }
    }

    @Override
    public boolean isNewsExist(String title) {
        if (title == null) {
            log.error("Null input in isNewsExist()");
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

