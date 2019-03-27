package com.epam.newsmanagement.config;

import java.util.Properties;
import com.epam.newsmanagement.entity.Authority;
import com.epam.newsmanagement.entity.News;
import com.epam.newsmanagement.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import static org.hibernate.cfg.Environment.*;

@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScans(value = { @ComponentScan("com.epam.newsmanagement.dao"),
                          @ComponentScan("com.epam.newsmanagement.service"),
})
public class AppConfig {

  @Autowired
  private Environment environment;

  @Bean
  public LocalSessionFactoryBean sessionFactory() {
      LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

      Properties props = new Properties();

      props.put(DRIVER, environment.getProperty("oracle.driver"));
      props.put(URL, environment.getProperty("oracle.jdbcUrl"));
      props.put(USER, environment.getProperty("oracle.username"));
      props.put(PASS, environment.getProperty("oracle.password"));

      props.put(SHOW_SQL, environment.getProperty("hibernate.show_sql"));
      props.put(HBM2DDL_AUTO, environment.getProperty("hibernate.hbm2ddl.auto"));
      props.put(DIALECT, environment.getProperty("hibernate.dialect"));

      props.put(C3P0_MIN_SIZE, environment.getProperty("hibernate.c3p0.min_size"));
      props.put(C3P0_MAX_SIZE, environment.getProperty("hibernate.c3p0.max_size"));
      props.put(C3P0_ACQUIRE_INCREMENT, environment.getProperty("hibernate.c3p0.acquire_increment"));
      props.put(C3P0_TIMEOUT, environment.getProperty("hibernate.c3p0.timeout"));
      props.put(C3P0_MAX_STATEMENTS, environment.getProperty("hibernate.c3p0.max_statements"));

      factoryBean.setHibernateProperties(props);
      factoryBean.setAnnotatedClasses(User.class, Authority.class, News.class);

      return factoryBean;
  }

  @Bean
  public HibernateTransactionManager transactionManager() {
      HibernateTransactionManager transactionManager = new HibernateTransactionManager();
      transactionManager.setSessionFactory(sessionFactory().getObject());

      return transactionManager;
  }

  @Bean
  public HibernateTemplate hibernateTemplate() {
      return new HibernateTemplate(sessionFactory().getObject());
  }
}
