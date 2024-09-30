package org.example.data.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
@Table(name = "dette")
public class Dette {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Double montant;
    private Double montantVerser;

    @Transient
    private Double montantRestant;

    // Navigabilite
    @ManyToOne
    private Client client;
    @ManyToMany
    private List<Article> articles = new ArrayList<>();
    @ManyToMany(mappedBy = "dette")
    private List<Detail> details = new ArrayList<>();
    //
}
