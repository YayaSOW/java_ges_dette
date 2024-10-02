package org.example.core.factory;

import org.example.data.entities.Client;
import org.example.data.entities.User;
import org.example.views.View;

public interface ViewFactory {
    View<Client> getInstanceClientView();
    View<User> getInstanceUserView();
}
