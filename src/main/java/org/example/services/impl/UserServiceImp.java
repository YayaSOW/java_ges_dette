package org.example.services.impl;

import org.example.data.repositories.UserRepository;
import org.example.data.entities.User;
import org.example.services.UserService;

import java.util.List;

public class UserServiceImp implements UserService {
    private UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void create(User user) {
        userRepository.insert(user);
    }
    public List<User> findAll() {
        return userRepository.selectAll();
    }
}
