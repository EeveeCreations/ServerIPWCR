package nl.ipwcr.server.controllers;

import nl.ipwcr.server.daos.WebUserDAO;
import nl.ipwcr.server.models.WebUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public List<WebUser> getAllCategories() {
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

    @PutMapping(value = "/new")
    public WebUser addUser(@RequestBody WebUser newWebUser) {
        return webUserDAO.addUser(newWebUser);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        webUserDAO.deleteByUserId(id);
    }

}
