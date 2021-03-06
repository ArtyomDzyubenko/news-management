package com.epam.newsmanagement.controller;

import com.epam.newsmanagement.dto.NewsDTO;
import com.epam.newsmanagement.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @RequestMapping(value = "/news", method = RequestMethod.GET)
    public ResponseEntity<List<NewsDTO>> getAllNews() {
        List<NewsDTO> newsList = newsService.findAllNews();

        if (newsList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(newsList, HttpStatus.OK);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public ResponseEntity<NewsDTO> getNewsById(@PathVariable("id") Long id) {
        NewsDTO news = newsService.findNewsById(id);

        if (news.getId() == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(news, HttpStatus.OK);
    }


    @RequestMapping(value = "/news", method = RequestMethod.POST)
    public ResponseEntity<Void> addNews(@Valid @RequestBody NewsDTO news, BindingResult result){
        if (result.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        boolean success = newsService.saveNews(news);

        if (!success) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/news", method = RequestMethod.PUT)
    public ResponseEntity<NewsDTO> updateNews(@Valid @RequestBody NewsDTO news, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        boolean success = newsService.updateNews(news);

        if (!success) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(news, HttpStatus.OK);
    }

    @RequestMapping(value = "/news", method = RequestMethod.PATCH)
    public ResponseEntity<Void> deleteNewsList(@RequestBody List<NewsDTO> news) {
        news.forEach(newsService::deleteNews);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
