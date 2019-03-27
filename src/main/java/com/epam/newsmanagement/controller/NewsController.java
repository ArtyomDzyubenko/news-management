package com.epam.newsmanagement.controller;

import com.epam.newsmanagement.dto.NewsDTO;
import com.epam.newsmanagement.entity.Authority;
import com.epam.newsmanagement.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.List;

@RestController
public class NewsController {

    @Autowired
    private NewsService newsService;

    @RequestMapping(value = "/news", method = RequestMethod.GET)
    public ResponseEntity<List<NewsDTO>> getAllNews() {
        List<NewsDTO> newsList = newsService.findAllNews();

        return new ResponseEntity<>(newsList, HttpStatus.OK);
    }

    @RequestMapping(value = "/news/{id}", method = RequestMethod.GET)
    public ResponseEntity<NewsDTO> getNewsById(@PathVariable("id") Long id) {
        NewsDTO news = newsService.findNewsById(id);

        return new ResponseEntity<>(news, HttpStatus.OK);
    }


    @RequestMapping(value = "/news", method = RequestMethod.POST)
    public ResponseEntity<Void> addNews(@RequestBody NewsDTO news, UriComponentsBuilder builder){
        boolean success = newsService.saveNews(news);

        if (!success) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/news/{id}").buildAndExpand(news.getId()).toUri());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/news/{id}", method = RequestMethod.PUT)
    public ResponseEntity<NewsDTO> updateNews(@RequestBody NewsDTO news) {
        newsService.updateNews(news);

        return new ResponseEntity<>(news, HttpStatus.OK);
    }

    @RequestMapping(value = "/news", method = RequestMethod.PATCH)
    public ResponseEntity<Void> deleteNewsList(@RequestBody List<Long> newsIDs) {
        newsService.deleteNewsList(newsIDs);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
