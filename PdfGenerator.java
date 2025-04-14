package com.gestock.utils;

import com.gestock.models.ProduitStock;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.FileOutputStream;
import java.util.List;

public class PdfGenerator {

    public static void genererRapportStock(List<ProduitStock> stockListe, String fichier) {
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(fichier));
            document.open();

            document.add(new Paragraph("Rapport de Stock", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18)));
            document.add(new Paragraph(" ")); // ligne vide

            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(100);
            table.addCell("Produit ID");
            table.addCell("Quantité en Stock");

            for (ProduitStock p : stockListe) {
                table.addCell(String.valueOf(p.getId()));
                table.addCell(String.valueOf(p.getQuantite()));
            }

            document.add(table);
            document.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
