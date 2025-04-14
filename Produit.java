package com.gestock.models;

// Classe représentant un produit
public class Produit {
    // Attributs privés du produit
    private int id;            // Identifiant du produit
    private String nom;        // Nom du produit
    private int quantite;      // Quantité en stock
    private double prix;       // Prix du produit

    // Constructeur vide 
    public Produit() {
    }

    // Constructeur avec tous les attributs
    public Produit(int id, String nom, int quantite, double prix) {
        this.id = id;
        this.nom = nom;
        this.quantite = quantite;
        this.prix = prix;
    }

    // Constructeur sans id (utilisé pour l ajout d'un nouveau produit)
    public Produit(String nom, int quantite, double prix) {
        this.nom = nom;
        this.quantite = quantite;
        this.prix = prix;
    }

    // Getter pour l'id
    public int getId() {
        return id;
    }

    // Getter pour le nom
    public String getNom() {
        return nom;
    }

    // Getter pour la quantité
    public int getQuantite() {
        return quantite;
    }

    // Getter pour le prix
    public double getPrix() {
        return prix;
    }

    // Setter pour l'id
    public void setId(int id) {
        this.id = id;
    }

    // Setter pour le nom
    public void setNom(String nom) {
        this.nom = nom;
    }

    // Setter pour la quantité
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    // Setter pour le prix
    public void setPrix(double prix) {
        this.prix = prix;
    }
}
