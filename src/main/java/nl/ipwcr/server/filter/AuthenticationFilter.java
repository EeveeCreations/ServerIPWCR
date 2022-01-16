package nl.ipwcr.server.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import nl.ipwcr.server.models.UserRole;
import nl.ipwcr.server.models.WebUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private static final String HASHED_ALOGORITHEM = "EeveeCreation";
    private final int MINUTES_OF_VALIDATION = 10;
    private final int REFRESH_OF_VALIDATION = 120;
    private final int MILISECONDS_TO_SECONDS = 1000;
    private final int A_MINUTE = 60;


    @Autowired
    private final AuthenticationManager authenticationManager;

    public AuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authentication) throws IOException, ServletException {
        WebUser user = (WebUser) authentication.getPrincipal();
//        TODO: CHange "secret" To a HAshed Value to be more secure
        Algorithm algorithm = Algorithm.HMAC256(HASHED_ALOGORITHEM.getBytes());
        String accessToken = JWT.create()
                .withSubject(user.getName())
                .withExpiresAt(new Date(System.currentTimeMillis() + MINUTES_OF_VALIDATION * A_MINUTE * MILISECONDS_TO_SECONDS))
                .withClaim("roles", user.getRoles().stream()
//                        .map(GrantedAuthority::getAuthority)
                        .map(UserRole::getRoleName)
                        .collect(Collectors.toList()))
                .sign(algorithm);

        String RefreshToken = JWT.create()
                .withSubject(user.getName())
                .withExpiresAt(new Date(System.currentTimeMillis() + REFRESH_OF_VALIDATION * A_MINUTE * MILISECONDS_TO_SECONDS))
                .withIssuer(request.getRequestURL().toString())
                .sign(algorithm);
        Map<String,String> tokens = new HashMap<>();
        tokens.put("accessToken",accessToken);
        tokens.put("refreshToken",RefreshToken);
        response.setContentType(APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(response.getOutputStream(),tokens);

    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        String userName = request.getParameter("username");
        String password = request.getParameter("passcode");
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userName, password);
        return this.authenticationManager.authenticate(authenticationToken);
    }
}
