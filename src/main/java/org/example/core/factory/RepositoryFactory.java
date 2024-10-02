package org.example.core.factory;

import org.example.data.repositories.ClientRepository;
import org.example.data.repositories.UserRepository;

public interface RepositoryFactory {
    ClientRepository getInstanceClientRepository() ;
    UserRepository getInstanceUserRepository();
}
