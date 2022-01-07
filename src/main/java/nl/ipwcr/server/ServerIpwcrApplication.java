package nl.ipwcr.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.jdbc.core.JdbcTemplate;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@SpringBootApplication
//        (exclude = {DataSourceAutoConfiguration.class,
//                SecurityAutoConfiguration.class})
public class ServerIpwcrApplication extends SpringBootServletInitializer {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(ServerIpwcrApplication.class, args);
    }

//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("nl.ipwcr.server"))
//                .paths(PathSelectors.any())
//                .build()
//                .apiInfo(metaData());
//    }
//
//    private ApiInfo metaData() {
//        return new ApiInfo(
//                "IPWCR Server",
//                "Spring Boot REST API for the IPWCR shop of School",
//                "1.0",
//                "Terms of service",
//                new Contact("Eefje", "https://springframework.guru/about/", "s1126086@student.hsleiden.nl"),
//                "Apache License Version 2.0",
//                "https://www.apache.org/licenses/LICENSE-2.0",
//                Collections.emptyList());
//    }

}
