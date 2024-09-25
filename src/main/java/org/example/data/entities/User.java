package org.example.data.entities;

import lombok.Data;
import org.example.data.enums.RoleEnum;

@Data
public class User {
    private int id;
    private String nom;
    private String prenom;
    private String login;
    private String password;
    private RoleEnum role;
    private boolean etat;
    private static int nbreUser;

    public User() {
        id = ++nbreUser;
    }
}
