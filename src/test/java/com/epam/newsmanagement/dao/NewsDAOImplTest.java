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
    public void testSaveNews() {
        newsDAO.saveNews(getTestNews());

        List<News> newsList = newsDAO.findAllNews();

        Assert.assertEquals(1, newsList.size());
    }

    @Test
    public void testFindAllNews() {
        newsDAO.saveNews(getTestNews());

        List<News> newsList = newsDAO.findAllNews();

        Assert.assertEquals(1, newsList.size());
    }

    @Test
    public void testFindNewsById() {
        newsDAO.saveNews(getTestNews());

        News news = newsDAO.findNewsById(2L);

        Assert.assertEquals("title", news.getTitle());
    }

    @Test
    public void testUpdateNews() {
        newsDAO.saveNews(getTestNews());

        News updated = new News();
        updated.setId(4L);
        updated.setTitle("updated title");
        updated.setDate(Date.valueOf("2012-12-31"));
        updated.setBrief("updated brief");
        updated.setContent("updated content");
        updated.setUsername("username");

        newsDAO.updateNews(updated);

        List<News> newsList = newsDAO.findAllNews();

        Assert.assertEquals("updated title", newsList.get(0).getTitle());
        Assert.assertEquals("updated brief", newsList.get(0).getBrief());
        Assert.assertEquals("updated content", newsList.get(0).getContent());
    }

    @Test
    public void testDeleteNews() {
        newsDAO.saveNews(getTestNews());

        News news = getTestNews();

        newsDAO.deleteNews(news);

        List<News> newsList = newsDAO.findAllNews();

        Assert.assertEquals(0, newsList.size());
    }

    private News getTestNews(){
        News news = new News();
        news.setUsername("username");
        news.setTitle("title");
        news.setDate(Date.valueOf("2001-12-31"));
        news.setBrief("brief");
        news.setContent("content");

        return news;
    }
}
