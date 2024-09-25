package org.example.data.entities;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Client {
    private int id;
    private String surname;
    private String telephone;
    private String address;
    private static int nbreClient;

    // Navigabilite
    //OneToOne (Client => User)
    private User user;
    //OneToMany (Client => Dette)
    private List<Dette> dettes =new ArrayList<>();

    public Client() {
        id = ++nbreClient;
    }
}
