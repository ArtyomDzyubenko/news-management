package com.epam.newsmanagement.configuration;

import com.epam.newsmanagement.dao.NewsDAO;
import com.epam.newsmanagement.dao.NewsDAOImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "com.epam.newsmanagement.dao"
})
public class TestConfig {

    @Bean
    public NewsDAO newsDAO() {
        return new NewsDAOImpl();
    }
}
