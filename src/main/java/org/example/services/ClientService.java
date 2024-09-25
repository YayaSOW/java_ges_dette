package org.example.services;

import org.example.data.entities.Client;

import java.util.List;

public interface ClientService {
    void create(Client client);
    List<Client> findAll();
    Client search(String telephone);
}
