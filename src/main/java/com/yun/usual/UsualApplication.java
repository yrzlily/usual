package com.yun.usual;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author yrz
 */
@SpringBootApplication
public class UsualApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(UsualApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(UsualApplication.class);
    }


}

