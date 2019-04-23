package com.epam.newsmanagement.dao;

import com.epam.newsmanagement.configuration.AppTestConfig;
import com.epam.newsmanagement.configuration.TestConfig;
import com.epam.newsmanagement.entity.News;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppTestConfig.class, TestConfig.class})
@Transactional
@Repository
public class NewsDAOImplTest {

    @Autowired
    NewsDAO newsDAO;

    @Test
    public void testAddNews() {
        News news = new News();
        news.setUsername("username");
        news.setTitle("title");
        news.setDate(Date.valueOf("2001-12-31"));
        news.setBrief("brief");
        news.setContent("content");

        newsDAO.saveNews(news);

        List<News> newsList = newsDAO.findAllNews();

        Assert.assertEquals(1, newsList.size());
    }

    @Test
    public void testFindAllNews() {
        List<News> newsList = newsDAO.findAllNews();

        Assert.assertEquals(1, newsList.size());
    }
}
