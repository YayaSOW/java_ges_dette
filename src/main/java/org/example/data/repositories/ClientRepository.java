package org.example.data.repositories;

import org.example.core.repository.Repository;
import org.example.data.entities.Client;

public interface ClientRepository extends Repository<Client> {
    Client selectByTelephone(String telephone);
}
