package org.example.data.repositories.list;

import org.example.data.repositories.UserRepository;
import org.example.core.repository.impl.RepositoryListImp;
import org.example.data.entities.User;

public class UserRepositoryList extends RepositoryListImp<User> implements UserRepository {
    @Override
    public User selectById(int id) {
        return null;
    }

    @Override
    public User selectByLogin(String login) {
        return null;
    }
}
