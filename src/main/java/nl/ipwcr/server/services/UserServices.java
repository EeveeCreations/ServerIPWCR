package nl.ipwcr.server.services;

import nl.ipwcr.server.models.UserRole;
import nl.ipwcr.server.models.WebUser;
import org.springframework.stereotype.Service;

import java.util.List;
public interface UserServices {
    WebUser addUser(WebUser webUser);
    UserRole addRole(UserRole userRole);
    void addRoleToUser(Long id, Long roleId);
    WebUser getById(Long id);
    List<WebUser> getAll();
    WebUser getByName(String userName);
}
