package com.gestock.dao;

import com.gestock.models.MouvementStock;
import com.gestock.models.ProduitStock;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StockDAO {
    private Connection connection;

    public StockDAO(Connection connection) {
        this.connection = connection;
    }
    public List<ProduitStock> getEtatStock() throws SQLException {
        List<ProduitStock> stocks = new ArrayList<>();
        String sql = "SELECT id, quantite FROM produit";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ProduitStock produit = new ProduitStock(rs.getInt("id"), rs.getInt("quantite"));
                stocks.add(produit);
            }
        }

        return stocks;
    }

    // Ajouter un mouvement d'entrée ou de sortie
    public void ajouterMouvement(MouvementStock mouvement) throws SQLException {
        String sql = "INSERT INTO mouvement_stock (produit_id, type_mouvement, quantite, date_mouvement) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, mouvement.getProduitId());
            stmt.setString(2, mouvement.getTypeMouvement());
            stmt.setInt(3, mouvement.getQuantite());
            stmt.setTimestamp(4, mouvement.getDateMouvement());
            stmt.executeUpdate();
        }
    }

    // Mettre à jour la quantité en fonction du type de mouvement
    public void miseAJourQuantite(int produitId, int quantite, String type) throws SQLException {
        String operation = type.equalsIgnoreCase("ENTREE") ? "+" : "-";
        String sql = "UPDATE produit SET quantite = quantite " + operation + " ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, quantite);
            stmt.setInt(2, produitId);
            stmt.executeUpdate();
        }
    }

    // Vérifier la quantité disponible avant une sortie
    public int getQuantiteDisponible(int produitId) throws SQLException {
        String sql = "SELECT quantite FROM produit WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, produitId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("quantite");
            }
        }
        return 0;
    }

    // Récupérer tous les mouvements
    public List<MouvementStock> getTousLesMouvements() throws SQLException {
        List<MouvementStock> mouvements = new ArrayList<>();
        String sql = "SELECT * FROM mouvement_stock ORDER BY date_mouvement DESC";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                MouvementStock mouvement = new MouvementStock(
                        rs.getInt("produit_id"),
                        rs.getString("type_mouvement"),
                        rs.getInt("quantite")
                );
                mouvement.setId(rs.getInt("id"));
                mouvement.setDateMouvement(rs.getTimestamp("date_mouvement"));
                mouvements.add(mouvement);
            }
        }
        return mouvements;
    }

    // Récupérer les mouvements par produit
    public List<MouvementStock> getMouvementsParProduit(int produitId) throws SQLException {
        List<MouvementStock> mouvements = new ArrayList<>();
        String sql = "SELECT * FROM mouvement_stock WHERE produit_id = ? ORDER BY date_mouvement DESC";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, produitId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                MouvementStock mouvement = new MouvementStock(
                        rs.getInt("produit_id"),
                        rs.getString("type_mouvement"),
                        rs.getInt("quantite")
                );
                mouvement.setId(rs.getInt("id"));
                mouvement.setDateMouvement(rs.getTimestamp("date_mouvement"));
                mouvements.add(mouvement);
            }
        }
        return mouvements;
    }
}
