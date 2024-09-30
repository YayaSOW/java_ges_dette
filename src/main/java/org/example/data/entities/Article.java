package org.example.data.entities;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String libelle;
    private double prix;
    private int qteStock;
    private static int nbrArticles;

    @ManyToMany(mappedBy = "articles")
    private List<Dette> dettes = new ArrayList<>();

    @ManyToMany(mappedBy = "article")
    private List<Detail> details = new ArrayList<>();

    public Article(String libelle, double prix, int qteStock) {
        this.libelle = libelle;
        this.prix = prix;
        this.qteStock = qteStock;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", prix=" + prix +
                ", qteStock=" + qteStock +
                '}';
    }

    // Navigabilite
    // OneToMany (Article => Detail)
    // private List<Detail> details = new ArrayList<>();
    public Article() {
        id = ++nbrArticles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQteStock() {
        return qteStock;
    }

    public void setQteStock(int qteStock) {
        this.qteStock = qteStock;
    }
}
