package com.epam.newsmanagement.dao;

import com.epam.newsmanagement.entity.News;
import java.util.List;

public interface NewsDAO {
    List<News> findAllNews();
    List<News> findUserNews(String username);
    News findNewsById(Long id);
    void saveNews(News news);
    void updateNews(News news);
    void deleteNewsList(List<Long> IDsList);
    boolean isNewsExist(String title);
}
