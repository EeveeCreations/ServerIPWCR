package nl.ipwcr.server.daos;

import lombok.extern.slf4j.Slf4j;
import nl.ipwcr.server.models.UserRole;
import nl.ipwcr.server.models.WebUser;
import nl.ipwcr.server.repositorys.UserRoleRepository;
import nl.ipwcr.server.repositorys.WebUserRepository;
import nl.ipwcr.server.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Component
@Slf4j
public class WebUserDAO implements UserDetailsService, UserServices {

    @Autowired
    private WebUserRepository webUserRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public WebUserDAO(WebUserRepository webUserRepository) {
        this.webUserRepository = webUserRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        WebUser user = webUserRepository.findByName(username);
        if (user == null) {
            log.error("USer not found");
            throw new UsernameNotFoundException("USer not found in DB");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(userRole -> {
            authorities.add(new SimpleGrantedAuthority(userRole.getRoleName()));

        });
        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPasscode(), authorities);
    }

    public List<WebUser> getAll() {
        ArrayList<WebUser> webUsers = (ArrayList<WebUser>) this.webUserRepository.findAll();
        webUsers.sort(Comparator.comparingLong(WebUser::getId));
        return webUsers;
    }

    @Override
    public WebUser getByName(String userName) {
        return webUserRepository.findByName(userName);
    }

    @Override
    public WebUser getById(Long id) {
        Optional<WebUser> optionalUser = webUserRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This user id: " + id + "has not found");
        }
        return optionalUser.get();
    }

    public Optional<WebUser> getByIdOptional(long id) {
        return webUserRepository.findById(id);
    }

    public void deleteByUserId(long userId) {
        webUserRepository.deleteById(userId);
    }

    @Override
    public WebUser addUser(WebUser newWebUser) {
        newWebUser.setPasscode(passwordEncoder.encode(newWebUser.getPasscode()));
        return webUserRepository.save(newWebUser);
    }

    @Override
    public UserRole addRole(UserRole userRole) {
       return userRoleRepository.save(userRole);
    }

    @Override
    public void addRoleToUser(Long id, Long roleId) {
        WebUser user = getById(id);
        Optional<UserRole> role = userRoleRepository.findById(roleId);
        role.ifPresent(userRole -> user.getRoles().add(userRole));

    }

}
