package org.example.data.repositories.bdSQL;

import java.util.List;

import org.example.core.repository.impl.RepositoryJpaImp;
import org.example.data.entities.Client;
import org.example.data.repositories.ClientRepository;

public class ClientRepositoryJpa extends RepositoryJpaImp<Client> implements ClientRepository {

    @Override
    public List<Client> selectAll() {
        return  this.em.createQuery("SELECT c FROM Client c", Client.class).getResultList();
    }

    @Override
    public Client selectByTelephone(String telephone) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectByTelephone'");
    }
}
