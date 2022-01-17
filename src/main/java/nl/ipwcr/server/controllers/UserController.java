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
import org.springframework.security.core.userdetails.UserDetails;
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
@RequestMapping("/user")
@RestController
public class UserController {
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

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        webUserDAO.deleteByUserId(id);
    }

    }
