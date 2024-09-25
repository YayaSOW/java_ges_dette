package org.example.core.factory.impl;

import org.example.data.repositories.ClientRepository;
import org.example.data.repositories.UserRepository;
import org.example.data.repositories.bdSQL.ClientRepositoryBD;
import org.example.data.repositories.bdPG.UserRepositoryBDP;

public class Factory {
    private static ClientRepository clientRepository;
    private static UserRepository userRepository=null;

    public static ClientRepository getInstanceClientRepository() {
        if(clientRepository==null) {
            clientRepository=new ClientRepositoryBD();
        }
        return clientRepository;
    }

    public static UserRepository getInstanceUserRepository() {
        if(userRepository==null) {
            userRepository=new UserRepositoryBDP();
        }
        return userRepository;
    }
}
