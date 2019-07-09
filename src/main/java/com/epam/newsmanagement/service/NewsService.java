package com.epam.newsmanagement.service;

import com.epam.newsmanagement.dto.NewsDTO;
import org.springframework.security.access.prepost.PreAuthorize;
import java.util.List;

public interface NewsService {
    List<NewsDTO> findAllNews();
    boolean saveNews(NewsDTO news);
    NewsDTO findNewsById(Long id);

    @PreAuthorize("#news.username == authentication.principal.username")
    boolean updateNews(NewsDTO news);

    @PreAuthorize("#news.username == authentication.principal.username")
    boolean deleteNews(NewsDTO news);
}
