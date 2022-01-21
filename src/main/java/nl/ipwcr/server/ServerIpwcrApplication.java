package nl.ipwcr.server;

import nl.ipwcr.server.services.UserServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
public class ServerIpwcrApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(
                ServerIpwcrApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:4200");
            }
        };
    }

    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
//    @Bean
//    CommandLineRunner runner(UserServices userServices){
//        return args -> {
////            userServices.addUser(new WebUser("Eevee","s1126086@student.hsleiden.nl","root112",null));
////            userServices.addRoleToUser(4L,1L);
////            userServices.addRoleToUser(4L,2L);
////            userServices.addRoleToUser(4L,3L);
//
//
////            userServices.addRole(new UserRole(null,"OWNER"));
////            userServices.addRole(new UserRole(null,"HACKER"));
//        };
//    }
}
