package org.example.data.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.example.data.enums.RoleEnum;
import org.hibernate.annotations.ColumnDefault;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length = 25,unique = true)
    private String nom;
    private String prenom;
    private String login;
    private String password;
    @Enumerated(EnumType.STRING)
    private RoleEnum role;
    @ColumnDefault(value = "true")
    private boolean etat;
    private static int nbreUser;

    //Navigabilite
    @OneToOne
    @JoinColumn(name = "clientId", nullable = true)
    private Client client;

    public User() {
        id = ++nbreUser;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", login=" + login + ", password=" + password
                + ", role=" + role + ", etat=" + etat + "]";
    }
}
