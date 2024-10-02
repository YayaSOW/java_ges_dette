package org.example.core.factory.impl;

import org.example.core.factory.RepositoryFactory;
import org.example.data.repositories.ClientRepository;
import org.example.data.repositories.UserRepository;
import org.example.data.repositories.bdPG.ClientRepositoryBDP;
import org.example.data.repositories.bdPG.UserRepositoryBDP;
import org.example.data.repositories.bdSQL.ClientRepositoryBD;
import org.example.data.repositories.bdSQL.UserRepositoryBD;
import org.example.data.repositories.jpa.ClientRepositoryJpa;
import org.example.data.repositories.jpa.UserRepositoryJpa;
import org.example.data.repositories.list.ClientRepositoryList;
import org.example.data.repositories.list.UserRepositoryList;

public class RepositoryFactoryImpl implements RepositoryFactory {
    private ClientRepository clientRepository;
    private UserRepository userRepository;

    @Override
    public ClientRepository getInstanceClientRepository() {
        if (clientRepository == null) {
            clientRepository = new ClientRepositoryJpa();
        }
        return clientRepository;
    }
    @Override
    public UserRepository getInstanceUserRepository() {
        if (userRepository == null) {
            userRepository = new UserRepositoryJpa();
        }
        return userRepository;
    }
}
