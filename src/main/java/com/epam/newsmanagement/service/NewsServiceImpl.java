package com.epam.newsmanagement.service;

import com.epam.newsmanagement.dao.NewsDAO;
import com.epam.newsmanagement.entity.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service("newsService")
@Transactional
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDAO newsDAO;

    @Override
    public List<News> findAllNews() {
        return  newsDAO.findAllNews();
    }

    @Override
    public boolean saveNews(News news) {
        if (newsDAO.isNewsExist(news.getTitle())) {
            return false;
        } else {
            newsDAO.saveNews(news);
            return true;
        }
    }

    @Override
    public News findNewsById(Long id) {
        return newsDAO.findNewsById(id);
    }


    @Override
    public void updateNews(News news) {
        newsDAO.updateNews(news);
    }

    @Override
    public void deleteNewsList(List<Long> IDsList) {
        newsDAO.deleteNewsList(IDsList);
    }
}


