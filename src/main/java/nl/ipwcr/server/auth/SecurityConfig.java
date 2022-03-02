package nl.ipwcr.server.auth;

import lombok.RequiredArgsConstructor;
import nl.ipwcr.server.filter.AuthenticationFilter;
import nl.ipwcr.server.filter.AuthorisationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@CrossOrigin(origins = {"*"})
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private final UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .userDetailsService(userDetailsService)
                .passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        AuthenticationFilter authenticationFilter = new AuthenticationFilter(authenticationManagerBean());
        httpSecurity.csrf();
        httpSecurity.cors();
        httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        setNeededAuthorisation(httpSecurity);
        httpSecurity.addFilter(authenticationFilter);
        httpSecurity.addFilterBefore(new AuthorisationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    private void setNeededAuthorisation(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.authorizeRequests().antMatchers(HttpMethod.POST,"/register").permitAll();
        httpSecurity.authorizeRequests().antMatchers(HttpMethod.POST,"/login").permitAll();
        httpSecurity.authorizeRequests().antMatchers(HttpMethod.POST,"/refresh").permitAll();

        httpSecurity.authorizeRequests().antMatchers(HttpMethod.GET, "/product/all").permitAll();
        httpSecurity.authorizeRequests().antMatchers(HttpMethod.POST, "/order/new").hasAnyAuthority("CLIENT");

        httpSecurity.authorizeRequests().antMatchers("/user/**").hasAnyAuthority("ADMIN");
        httpSecurity.authorizeRequests().antMatchers("/product/**").hasAnyAuthority("ADMIN");
        httpSecurity.authorizeRequests().antMatchers("/order/**").hasAnyAuthority("ADMIN");
        httpSecurity.authorizeRequests().antMatchers("/cart/**").hasAnyAuthority("ADMIN");

    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}

