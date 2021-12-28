package com.example.serveripwcr.daos;

import com.example.serveripwcr.models.User;
import com.example.serveripwcr.repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Component
public class UserDAO {

    @Autowired
    private UserRepository userRepository;

    public UserDAO(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        ArrayList<User> users = (ArrayList<User>) this.userRepository.findAll();
        users.sort(Comparator.comparingLong(User::getId));
        return users;
    }

    public User getById(long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This user id: " + id + "has not found");
        }
        return optionalUser.get();
    }

    public Optional<User> getByIdOptional(long id) {
        return userRepository.findById(id);
    }

    public void deleteByUserId(long userId) {
        userRepository.deleteById(userId);
    }

    public User addUser(User newUser) {
        return userRepository.save(newUser);
    }
}
