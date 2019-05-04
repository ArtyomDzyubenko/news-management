package com.epam.newsmanagement.service;

import com.epam.newsmanagement.dto.NewsDTO;
import java.util.List;

public interface NewsService {
    List<NewsDTO> findAllNews();
    boolean saveNews(NewsDTO news);
    NewsDTO findNewsById(Long id);
    boolean updateNews(NewsDTO news);
    boolean deleteNewsList(List<Long> IDsList);
}
