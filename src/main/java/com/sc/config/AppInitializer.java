
package com.sc.config;

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
        rootConfig.register(DbConfig.class);
        rootConfig.refresh();
        servletContext.addListener(new ContextLoaderListener(rootConfig));

        // servletRegister
        AnnotationConfigWebApplicationContext servletRegister = new AnnotationConfigWebApplicationContext();
        servletRegister.register(ServletConfig.class);


        ServletRegistration.Dynamic servletRegistration =
                servletContext.addServlet("servlet", new DispatcherServlet(servletRegister));


       servletRegistration.setMultipartConfig(new MultipartConfigElement("/", 2097152, 4194304, 50));

        // Multipart Filter Config
       FilterRegistration.Dynamic multipartFilter = servletContext.addFilter("multipartFilter", MultipartFilter.class);
       multipartFilter.addMappingForUrlPatterns(null, true, "/*");
        //Load  on startup*//*


        servletRegistration.setLoadOnStartup(1);

        // Add  Mapping
        servletRegistration.addMapping("/");

    }
}


