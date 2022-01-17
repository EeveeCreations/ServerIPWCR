package nl.ipwcr.server;

import nl.ipwcr.server.models.UserRole;
import nl.ipwcr.server.models.WebUser;
import nl.ipwcr.server.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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

    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    CommandLineRunner runner(UserServices userServices){
        return args -> {
            userServices.addUser(new WebUser("Eevee","s1126086@student.hsleiden.nl","root112",null));
            userServices.addRoleToUser(4L,1L);
            userServices.addRoleToUser(4L,2L);
            userServices.addRoleToUser(4L,3L);


//            userServices.addRole(new UserRole(null,"OWNER"));
//            userServices.addRole(new UserRole(null,"HACKER"));
        };

    }


}
