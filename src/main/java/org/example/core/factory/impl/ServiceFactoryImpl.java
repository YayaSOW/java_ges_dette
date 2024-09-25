package org.example.core.factory.impl;

import org.example.services.ClientService;
import org.example.services.UserService;
import org.example.services.impl.ClientServiceImp;
import org.example.services.impl.UserServiceImp;

public class ServiceFactoryImpl {
    RepositoryFactoryImpl repositoryFactoryImpl = new RepositoryFactoryImpl();
    private ClientService clientService;
    private UserService userService;

    public ClientService getInstanceClientService() {
        if (clientService == null) {
            clientService = new ClientServiceImp(repositoryFactoryImpl.getInstanceClientRepository());
        }
        return clientService;
    }
    public UserService getInstanceUserService() {
        if (userService == null) {
            userService = new UserServiceImp(repositoryFactoryImpl.getInstanceUserRepository());
        }
        return userService;
    }
}
