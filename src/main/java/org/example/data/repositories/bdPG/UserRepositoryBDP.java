package org.example.data.repositories.bdPG;

import org.example.data.repositories.UserRepository;
import org.example.data.entities.User;
import org.example.core.repository.impl.RepositoryBDImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserRepositoryBDP extends RepositoryBDImp<User> implements UserRepository {
    @Override
    public void insert(User data) {

    }

    @Override
    public List<User> selectAll() {
        return List.of();
    }

    @Override
    public User selectById(int id) {
        return null;
    }

    @Override
    public User selectByLogin(String login) {
        return null;
    }

    @Override
    public User convertToObject(ResultSet rs) throws SQLException {
        return null;
    }
}
