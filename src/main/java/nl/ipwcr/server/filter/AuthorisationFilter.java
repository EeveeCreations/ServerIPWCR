package nl.ipwcr.server.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import nl.ipwcr.server.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = {"http://localhost:4200", "*"})
public class AuthorisationFilter extends OncePerRequestFilter {

    private final TokenService tokenService = new TokenService();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        response.setContentType(APPLICATION_JSON_VALUE);
        if (request.getServletPath().equals("/login") ||
                request.getServletPath().equals("/refresh") ||
                request.getServletPath().equals("/register") ||
                (request.getServletPath().startsWith("/order/new") && request.getMethod().equals("GET")) ||
                (request.getServletPath().startsWith("/product/all") && request.getMethod().equals("GET")) ||
                request.getServletPath().equals("/requestChangePassword") ||
                request.getServletPath().equals("/resetPassword")){
            filterChain.doFilter(request, response);
        } else {
            String authorisationHeader = request.getHeader(AUTHORIZATION);
            if (authorisationHeader != null && authorisationHeader.startsWith("Bearer ")) {
                try {
                    String token = authorisationHeader.substring("Bearer ".length());
                    String userName = tokenService.getUserNameFromToken(token);
                    Collection<SimpleGrantedAuthority> authorities = this.tokenService.getRolesFromToken(token);
                    response.setStatus(200);
                    UsernamePasswordAuthenticationToken authenticationToken =
                            new UsernamePasswordAuthenticationToken(userName, null, authorities);
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
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
}
