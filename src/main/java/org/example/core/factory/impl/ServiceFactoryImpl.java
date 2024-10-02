package org.example.core.factory.impl;

import org.example.core.factory.ServiceFactory;
import org.example.services.ClientService;
import org.example.services.UserService;
import org.example.services.impl.ClientServiceImp;
import org.example.services.impl.UserServiceImp;

public class ServiceFactoryImpl implements ServiceFactory {
    RepositoryFactoryImpl repositoryFactoryImpl = new RepositoryFactoryImpl();
    private ClientService clientService;
    private UserService userService;

    @Override
    public ClientService getInstanceClientService() {
        if (clientService == null) {
            clientService = new ClientServiceImp(repositoryFactoryImpl.getInstanceClientRepository());
        }
        return clientService;
    }
    @Override
    public UserService getInstanceUserService() {
        if (userService == null) {
            userService = new UserServiceImp(repositoryFactoryImpl.getInstanceUserRepository());
        }
        return userService;
    }
}
