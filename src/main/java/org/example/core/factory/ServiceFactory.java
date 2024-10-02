package org.example.core.factory;

import org.example.services.ClientService;
import org.example.services.UserService;

public interface ServiceFactory {
    ClientService getInstanceClientService();
    UserService getInstanceUserService();
}
