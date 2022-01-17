package nl.ipwcr.server.controllers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import nl.ipwcr.server.daos.WebUserDAO;
import nl.ipwcr.server.models.UserRole;
import nl.ipwcr.server.models.WebUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static nl.ipwcr.server.filter.AuthenticationFilter.HASHED_ALOGORITHEM;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/auth")
@RestController
public class UserController {

    private static final int MINUTES_OF_VALIDATION = 10;
    private static final int A_MINUTE = 60;
    private static final int MILISECONDS_TO_SECONDS = 1000;
    @Autowired
    public final WebUserDAO webUserDAO;

    public UserController(WebUserDAO webUserDAO) {
        this.webUserDAO = webUserDAO;
    }

    @GetMapping(value = "/all")
    public List<WebUser> getAllWebUsers() {
        return webUserDAO.getAll();
    }

    @GetMapping(value = "/{id}")
    public WebUser getUser(@PathVariable final Long id) {
        return webUserDAO.getById(id);
    }

    @PutMapping(value = "/{id}")
    public WebUser editUser(
            @RequestBody WebUser editWebUser,
            @PathVariable Long id) throws Exception {

        return webUserDAO.getByIdOptional(id)
                .map(webUser -> {
                    webUser.setName(editWebUser.getName());
                    webUser.setPasscode(editWebUser.getPasscode());
                    webUser.setEmail(editWebUser.getEmail());
                    webUser.setRoles(editWebUser.getRoles());
                    return webUserDAO.addUser(webUser);
                })
                .orElseThrow(() -> new Exception(
                        "No user found with id " + id + "\""));
    }

    @PutMapping(value = "/register")
    public WebUser addUser(@RequestBody WebUser newWebUser) {
        return webUserDAO.addUser(newWebUser);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        webUserDAO.deleteByUserId(id);
    }

    @GetMapping(value = "/token/refresh")
    public void refreshToken(HttpServletRequest request,
                             HttpServletResponse response,
                             FilterChain filterChain,
                             Authentication authentication) throws IOException, ServletException {
        String authorisationHeader = request.getHeader(AUTHORIZATION);
        String refreshToken = request.getHeader(AUTHORIZATION);
        if (authorisationHeader != null && authorisationHeader.startsWith("Bearer ")) {
            try {
                String RefreshToken = authorisationHeader.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC256(HASHED_ALOGORITHEM.getBytes());
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(RefreshToken);
                String userName = decodedJWT.getSubject();
                WebUser user = webUserDAO.getByName(userName);
                String accessToken = JWT.create()
                        .withSubject(user.getName())
                        .withExpiresAt(new Date(System.currentTimeMillis() + MINUTES_OF_VALIDATION * A_MINUTE * MILISECONDS_TO_SECONDS))
                        .withClaim("roles", user
                                .getRoles()
                                .stream()
                                .map(UserRole::getRoleName)
                                .collect(Collectors.toList()))
                        .sign(algorithm);
                Map<String,String> tokens = new HashMap<>();
                tokens.put("accessToken",accessToken);
                tokens.put("refreshToken",RefreshToken);
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(),tokens);
            } catch (Exception exception) {
//                    TODO: Costumise
                response.setHeader("error", exception.getMessage());
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
//                    response.sendError(HttpServletResponse.SC_NOT_FOUND);
                Map<String, String> error = new HashMap<>();
                error.put("error_message", exception.getMessage());
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), error);
            }

        } else {
            filterChain.doFilter(request, response);
        }


    }
}
