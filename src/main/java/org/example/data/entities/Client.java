package org.example.data.entities;

import lombok.Data;
import lombok.Generated;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 25, unique = true)
    private String surname;
    @Column(length = 25, unique = true)
    private String telephone;
    @Column(length = 25, unique = true)
    private String address;
    private static int nbreClient;

    // Navigabilite
    //OneToOne (Client => User)
    @OneToOne
    @JoinColumn(name = "\"userId\"", nullable = true)
    private User user;
    //OneToMany (Client => Dette)
    // private List<Dette> dettes =new ArrayList<>();

    public Client() {
        id = ++nbreClient;
    }

    @Override
    public String toString() {
        return "Client [id=" + id + ", surname=" + surname + ", telephone=" + telephone + ", address=" + address
                + ", user=" + user + "]";
    }
}
