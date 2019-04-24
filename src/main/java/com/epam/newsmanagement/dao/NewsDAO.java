package com.epam.newsmanagement.dao;

import com.epam.newsmanagement.entity.News;
import java.util.List;

public interface NewsDAO {
    List<News> findAllNews();
    List<News> findUserNews(String username);
    News findNewsById(Long id);
    boolean saveNews(News news);
    boolean updateNews(News news);
    boolean deleteNewsList(List<Long> IDsList);
    boolean isNewsExist(String title);
}
