package com.gestock.models;

import java.sql.Timestamp;

public class MouvementStock {
    private int id;
    private int produitId;
    private String typeMouvement; // "ENTREE" ou "SORTIE"
    private int quantite;
    private Timestamp dateMouvement;

    // Constructeur
    public MouvementStock(int produitId, String typeMouvement, int quantite) {
        this.produitId = produitId;
        this.typeMouvement = typeMouvement;
        this.quantite = quantite;
        this.dateMouvement = new Timestamp(System.currentTimeMillis());
    }

    // Getters
    public int getId() {
        return id;
    }

    public int getProduitId() {
        return produitId;
    }

    public String getTypeMouvement() {
        return typeMouvement;
    }

    public int getQuantite() {
        return quantite;
    }

    public Timestamp getDateMouvement() {
        return dateMouvement;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setProduitId(int produitId) {
        this.produitId = produitId;
    }

    public void setTypeMouvement(String typeMouvement) {
        this.typeMouvement = typeMouvement;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setDateMouvement(Timestamp dateMouvement) {
        this.dateMouvement = dateMouvement;
    }
}
