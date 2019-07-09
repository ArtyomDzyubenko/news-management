package com.epam.newsmanagement.service;

import com.epam.newsmanagement.dao.NewsDAO;
import com.epam.newsmanagement.dao.UserDAO;
import com.epam.newsmanagement.dto.NewsDTO;
import com.epam.newsmanagement.dtoConverter.NewsDTOConverter;
import com.epam.newsmanagement.entity.News;
import com.epam.newsmanagement.entity.User;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Log4j
@Service("newsService")
@Transactional
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDAO newsDAO;

    @Override
    public List<NewsDTO> findAllNews() {
        List<News> newsList = newsDAO.findAllNews();

        if (newsList == null) {
            log.error("Null in findAllNews()");

            return new ArrayList<>();
        }

        return newsList.stream()
                .map(NewsDTOConverter::Entity2DTO)
                .collect(Collectors.toList());
    }

    @Override
    public boolean saveNews(NewsDTO news) {
        boolean success = false;

        if (news == null) {
            log.error("Null in saveNews()");

            return success;
        }

        News entity = NewsDTOConverter.DTO2Entity(news);

        if (newsDAO.isNewsExist(entity.getTitle())) {
            return success;
        } else {
            newsDAO.saveNews(entity);
            return !success;
        }
    }

    @Override
    public NewsDTO findNewsById(Long id) {
        if (id == null) {
            log.error("Null in findNewsById()");

            return new NewsDTO();
        }

        News entity = newsDAO.findNewsById(id);

        return NewsDTOConverter.Entity2DTO(entity);
    }
    @Override
    public boolean updateNews(NewsDTO news) {
        boolean success = true;

        if (news == null) {
            log.error("Null in updateNews()");

            return !success;
        }

        News entity = NewsDTOConverter.DTO2Entity(news);

        return newsDAO.updateNews(entity);
    }

    @Override
    public boolean deleteNews(NewsDTO news) {
        boolean success = true;

        if (news == null) {
            log.error("Null in deleteNewsList()");

            return !success;
        }

        News entity = NewsDTOConverter.DTO2Entity(news);

        return newsDAO.deleteNews(entity);
    }
}


