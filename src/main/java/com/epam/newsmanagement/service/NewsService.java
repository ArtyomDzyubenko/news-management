package com.epam.newsmanagement.service;

import com.epam.newsmanagement.entity.News;

import java.util.List;

public interface NewsService {
    List<News> findAllNews();
    boolean saveNews(News news);
    News findNewsById(Long id);
    void updateNews(News news);
    void deleteNewsList(List<Long> IDsList);
}
