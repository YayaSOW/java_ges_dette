package org.example.data.repositories.jpa;

import org.example.core.repository.impl.RepositoryJpaImp;
import org.example.data.entities.Client;
import org.example.data.repositories.ClientRepository;

public class ClientRepositoryJpa extends RepositoryJpaImp<Client> implements ClientRepository {

    public ClientRepositoryJpa() {
        super(Client.class);
    }

    @Override
    public Client selectByTelephone(String telephone) {
        return this.em.createQuery("SELECT c FROM Client c where c.telephone like :tel", Client.class)
                .setParameter("tel", telephone)
                .getSingleResult();
    }
}
