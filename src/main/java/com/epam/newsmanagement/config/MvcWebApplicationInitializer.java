package com.epam.newsmanagement.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MvcWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
  @Override
  protected Class<?>[] getRootConfigClasses() {
      return new Class[] { AppConfig.class, WebSecurityConfig.class, SwaggerConfig.class };
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
      return new Class[] { WebConfig.class };
  }

  @Override
  protected String[] getServletMappings() {
      return new String[] { "/" };
  }
}
