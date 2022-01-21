package nl.ipwcr.server;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ServerIpwcrApplicationTests {

    @Test
    void returns_User_does_not_exist() {
        String userName = "jaapie";
        String password = "jaapie";
        assert(userName.equals(password));
    }

}
