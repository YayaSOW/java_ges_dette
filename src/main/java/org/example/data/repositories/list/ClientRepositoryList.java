package org.example.data.repositories.list;

import org.example.data.repositories.ClientRepository;
import org.example.core.repository.impl.RepositoryListImp;
import org.example.data.entities.Client;

public class ClientRepositoryList extends RepositoryListImp<Client> implements ClientRepository {

    @Override
    public Client selectByTelephone(String telephone) {
        return list.stream().
                filter(client -> client.getTelephone().compareToIgnoreCase(telephone)==0)
                .findFirst().orElse(null);
    }
}
