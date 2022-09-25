package com.sc.config;

import com.sc.Properties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@ComponentScan(basePackages = {"com.sc.service"})
public class RootConfig {

    /*@Bean(name ="multipartResolver")
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(Properties.MAX_UPL_SIZE);

        return multipartResolver;
    }
*/
}
