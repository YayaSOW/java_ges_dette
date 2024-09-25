package org.example.services;

import org.example.data.entities.User;

import java.util.List;

public interface UserService {
    void create(User user);
    List<User> findAll();
}
