package nl.ipwcr.server.controllers;

import nl.ipwcr.server.daos.UserDAO;
import nl.ipwcr.server.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

    @Autowired
    public final UserDAO userDAO;

    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping(value = "/user/all")
    public List<User> getAllCategories() {
        return userDAO.getAll();
    }

    @GetMapping(value = "/user/{id}")
    public User getUser(@PathVariable final Long id) {
        return userDAO.getById(id);
    }

    @PutMapping(value = "/user/{id}")
    public User editUser(@RequestBody User editUser, @PathVariable Long id) throws Exception {

        return userDAO.getByIdOptional(id)
                .map(user -> {
                    user.setName(editUser.getName());
                    user.setPasscode(editUser.getPasscode());
                    user.setAdmin(editUser.isAdmin());
                    return userDAO.addUser(user);
                })
                .orElseThrow(() -> new Exception(
                        "No user found with id " + id + "\""));
    }

    @PutMapping(value = "/user")
    public User addUser(@RequestBody User newUser) {
        return userDAO.addUser(newUser);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id) {
        userDAO.deleteByUserId(id);
    }

}
