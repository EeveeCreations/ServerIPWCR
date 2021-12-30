package com.example.serveripwcr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
        (exclude = {DataSourceAutoConfiguration.class }, scanBasePackages= {
                "com.example.serveripwcr", "com.example.serverIpwcrApplication"})
public class ServerIpwcrApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ServerIpwcrApplication.class, args);
    }

}
