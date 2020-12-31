package com.myweb.miaosha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@EnableTransactionManagement
@SpringBootApplication
public class MiaoshaApplication{

    public static void main(String[] args) {
        SpringApplication.run(MiaoshaApplication.class, args);
    }

}
