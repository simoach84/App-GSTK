package com.gestock.controllers;

import com.gestock.dao.StockDAO;
import com.gestock.models.MouvementStock;
import com.gestock.models.ProduitStock;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class StockController {

    private StockDAO stockDAO;

    public StockController(Connection connection) {
        this.stockDAO = new StockDAO(connection);
    }

    // Ajouter un mouvement (entrée ou sortie)
    public boolean ajouterMouvement(int produitId, String type, int quantite) {
        if (!type.equalsIgnoreCase("ENTREE") && !type.equalsIgnoreCase("SORTIE")) {
            System.out.println("Type de mouvement invalide. Utilisez 'ENTREE' ou 'SORTIE'.");
            return false;
        }

        if (quantite <= 0) {
            System.out.println(" La quantité doit être supérieure à zéro.");
            return false;
        }

        MouvementStock mouvement = new MouvementStock(produitId, type.toUpperCase(), quantite);
        try {
            stockDAO.ajouterMouvement(mouvement);
            stockDAO.miseAJourQuantite(produitId, quantite, type);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    // Obtenir tous les mouvements
    public List<MouvementStock> listerMouvements() {
        try {
            return stockDAO.getTousLesMouvements();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Nouvelle méthode pour afficher l'état du stock
    public List<ProduitStock> listerStockActuel() throws SQLException {
        return stockDAO.getEtatStock();
    }
}
