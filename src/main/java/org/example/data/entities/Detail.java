package org.example.data.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "detail")
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Double prixVente;
    private Integer ateVendu;
    
    @ManyToOne
    private Article article;

    @ManyToOne
    private Dette dette;

}
