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

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<NewsDTO> findAllNews() {
        String userName = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        User user = userDAO.findUserByUsername(userName);

        List<News> newsList;

        if (user.getAuthority().getAuthority().contains("ADMIN")) {
            newsList = newsDAO.findAllNews();
        } else {
            newsList = newsDAO.findUserNews(user.getUsername());
        }

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
    public void updateNews(NewsDTO news) {
        if (news == null) {
            log.error("Null in updateNews()");

            return;
        }

        News entity = NewsDTOConverter.DTO2Entity(news);

        newsDAO.updateNews(entity);
    }

    @Override
    public void deleteNewsList(List<Long> IDsList) {
        if (IDsList == null) {
            log.error("Null in deleteNewsList()");

            return;
        }

        newsDAO.deleteNewsList(IDsList);
    }
}


