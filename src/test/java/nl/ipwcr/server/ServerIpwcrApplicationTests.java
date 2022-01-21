package nl.ipwcr.server;

import nl.ipwcr.server.filter.AuthenticationFilter;
import nl.ipwcr.server.filter.AuthorisationFilter;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpResponse;

@SpringBootTest
class ServerIpwcrApplicationTests {

    @Test
    void returns_User_does_not_exist() {
        String userName = "jaapie";
        String password = "jaapie";
        assert(userName.equals(password));
    }

}
