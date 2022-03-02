package nl.ipwcr.server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@SpringBootApplication
public class ServerIpwcrApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(
                ServerIpwcrApplication.class, args);
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200","https://eeveecreations.github.io","https://one-piece-shop-ipwcr-jpwbr.ondigitalocean.app/one-piece-shop-IPWCR"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Origin", "content-type"));
        configuration.setExposedHeaders(Arrays.asList("Authorization", "Origin", "content-type"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {

        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("https://eeveecreations.github.io");
                registry.addMapping("/**").allowedOrigins("http://localhost:4200");
                registry.addMapping("/**").allowedOrigins("https://one-piece-shop-ipwcr-jpwbr.ondigitalocean.app/one-piece-shop-IPWCR");

                registry.addMapping("/**").allowedHeaders("Authorization", "Origin", "Content-type");

            }
        };
    }


    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
