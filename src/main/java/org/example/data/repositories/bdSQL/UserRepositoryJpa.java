package org.example.data.repositories.bdSQL;

import java.util.List;

import org.example.core.repository.impl.RepositoryJpaImp;
import org.example.data.entities.User;
import org.example.data.repositories.UserRepository;

public class UserRepositoryJpa extends RepositoryJpaImp<User> implements UserRepository {

    @Override
    public List<User> selectAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectAll'");
    }

    @Override
    public User selectById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectById'");
    }

    @Override
    public User selectByLogin(String login) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectByLogin'");
    }
    
}
