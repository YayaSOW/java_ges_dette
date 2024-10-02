package org.example.core.factory.impl;

import org.example.core.factory.ViewFactory;
import org.example.data.entities.Client;
import org.example.data.entities.User;
import org.example.views.View;
import org.example.views.imp.ClientView;
import org.example.views.imp.UserView;

public class ViewFactoryImpl implements ViewFactory {
    private View<Client> clientView;
    private View<User> userView;

    @Override
    public View<Client> getInstanceClientView() {
        if (clientView == null) {
            clientView = new ClientView();
        }
        return clientView;
    }

    @Override
    public View<User> getInstanceUserView() {
        if (userView == null) {
            userView = new UserView();
        }
        return userView;
    }

}
