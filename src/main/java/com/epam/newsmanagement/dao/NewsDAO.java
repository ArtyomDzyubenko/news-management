package com.epam.newsmanagement.dao;

import com.epam.newsmanagement.entity.News;
import java.util.List;

public interface NewsDAO {
    List<News> findAllNews();
    News findNewsById(Long id);
    boolean saveNews(News news);
    boolean updateNews(News news);
    boolean deleteNews(News news);
    boolean isNewsExist(String title);
}
