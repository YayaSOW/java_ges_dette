package org.example.services.impl;

import org.example.data.repositories.ClientRepository;
import org.example.services.ClientService;
import org.example.data.entities.Client;

import java.util.List;

public class ClientServiceImp implements ClientService {
    private ClientRepository clientRepository;

    public ClientServiceImp(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void create(Client client) {
        clientRepository.insert(client);
    }
    public List<Client> findAll() {
        return clientRepository.selectAll();
    }
    public Client search(String telephone) {
        return clientRepository.selectByTelephone(telephone);
    }
}
