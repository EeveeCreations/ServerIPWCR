package nl.ipwcr.server.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import nl.ipwcr.server.daos.WebUserDAO;
import nl.ipwcr.server.models.UserRole;
import nl.ipwcr.server.models.WebUser;
import nl.ipwcr.server.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@RestController
@CrossOrigin(origins = {
        "*",
        "http://localhost:4200",
        "https://eeveecreations.github.io",
        "https://one-piece-shop-ipwcr-jpwbr.ondigitalocean.app/"})
@AllArgsConstructor
public class AuthenticationController {

    @Autowired
    private final WebUserDAO webUserDAO;

    @Autowired
    private final TokenService tokenService;


    @PostMapping(value = "/register", produces = "application/json")
    public WebUser addUser(@RequestBody WebUser newWebUser) {
        for(UserRole role: newWebUser.getRoles()){
            role.setRole("CLIENT");
        }
        return webUserDAO.addUser(newWebUser);
    }

    @GetMapping(value = "/refresh")
    public void refreshToken(HttpServletRequest request,
                             HttpServletResponse response,
                             FilterChain filterChain,
                             Authentication authentication) throws IOException, ServletException {
        String authorisationHeader = request.getHeader(AUTHORIZATION);
        String refreshToken = request.getHeader(AUTHORIZATION);
        if (authorisationHeader != null && authorisationHeader.startsWith("Bearer ")) {
            try {
                String userName = this.tokenService.getUserNameFromToken(authorisationHeader.substring("Bearer ".length()));
                WebUser user = webUserDAO.getByName(userName);
                String accessToken = tokenService.createForRefreshToken(user);
                Map<String, String> tokens = new HashMap<>();
                tokens.put("id", user.getId().toString());
                tokens.put("name", user.getName());
                tokens.put("email", user.getEmail());
                tokens.put("passcode", user.getPasscode());
                tokens.put("roles", user.getRoles().toString());
                tokens.put("accessToken", accessToken);
                tokens.put("refreshToken", refreshToken);
                new ObjectMapper().writeValue(response.getOutputStream(), tokens);
            } catch (Exception exception) {
                response.setHeader("error", exception.getMessage());
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                Map<String, String> error = new HashMap<>();
                error.put("error_message", exception.getMessage());
                new ObjectMapper().writeValue(response.getOutputStream(), error);
            }
        } else {
            filterChain.doFilter(request, response);
        }
    }
}

