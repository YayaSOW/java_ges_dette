package org.example.data.repositories;

import org.example.core.repository.Repository;
import org.example.data.entities.User;

public interface UserRepository extends Repository<User> {
     User selectById(int id);
     User selectByLogin(String login);

}
