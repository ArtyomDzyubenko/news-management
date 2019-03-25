package com.epam.newsmanagement.service;

import com.epam.newsmanagement.dto.NewsDTO;
import java.util.List;

public interface NewsService {
    List<NewsDTO> findAllNews();
    boolean saveNews(NewsDTO news);
    NewsDTO findNewsById(Long id);
    void updateNews(NewsDTO news);
    void deleteNewsList(List<Long> IDsList);
}
