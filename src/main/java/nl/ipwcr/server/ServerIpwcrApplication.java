package nl.ipwcr.server;
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
                registry.addMapping("/**").allowedOrigins("https://eeveecreations.github.io");
                registry.addMapping("/**").allowedOrigins("http://localhost:4200");
                registry.addMapping("/**").allowedOrigins("https://one-piece-shop-ipwcr-jpwbr.ondigitalocean.app/one-piece-shop-IPWCR");


            }
        };
    }

    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
