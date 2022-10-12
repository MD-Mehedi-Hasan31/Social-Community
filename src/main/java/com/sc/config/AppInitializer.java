
package com.sc.config;

import com.sc.Properties;
import com.sc.security.SecurityConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.multipart.support.MultipartFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;

public class AppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) {

        // root Config
        AnnotationConfigWebApplicationContext rootConfig = new AnnotationConfigWebApplicationContext();
        rootConfig.register(RootConfig.class, DbConfig.class, SecurityConfig.class);
        rootConfig.refresh();
        servletContext.addListener(new ContextLoaderListener(rootConfig));

        // servletConfig
        AnnotationConfigWebApplicationContext servletConfig = new AnnotationConfigWebApplicationContext();
        servletConfig.register(ServletConfig.class);
        ServletRegistration.Dynamic servletRegistration = servletContext.addServlet("servlet", new DispatcherServlet(servletConfig));

        //Multipart Config
        MultipartConfigElement multipartConfig = new MultipartConfigElement(Properties.TEMP_LOCATION, Properties.MAX_FILE_SIZE, Properties.MAX_REQUEST_SIZE, Properties.FILE_THRESHOLD_SIZE);
        servletRegistration.setMultipartConfig(multipartConfig);

        // Multipart Filter Config
        FilterRegistration.Dynamic multipartFilter = servletContext.addFilter("multipartFilter", MultipartFilter.class);
        multipartFilter.addMappingForUrlPatterns(null, true, "/*");

       //Load  on startup*//*
        servletRegistration.setLoadOnStartup(1);

        // Add  Mapping
        servletRegistration.addMapping("/");

    }
}


