# App-GSTK
Application de Gestion de stock

Nom de l’étudiant : Mohammed Achoch

Fonctionnalité : Génération des rapports de stock (PDF)

1\Objectif

L'objectif de cette partie est de permettre aux utilisateurs de générer un rapport PDF automatique à partir des données du stock. Cela permet :

•	d'avoir un aperçu imprimable de la quantité actuelle en stock,

•	de faciliter le suivi des produits disponibles,

•	de transmettre un état des stocks à un gestionnaire, un responsable ou une équipe externe.


2\Technologies utilisées


Java :	Langage principal de développement

JavaFX: Pour intégrer l’action “Générer PDF” à l’interface graphique

iTextPDF 5.x :	Librairie utilisée pour créer et manipuler des documents PDF

Modèle MVC :	Intégré dans la logique de gestion des données ProduitStock


3\Architecture de la solution

•	La génération est déléguée à une classe PdfGenerator située dans le package com.gestock.utils.

•	Cette classe contient une méthode :

public static void genererRapportStock(List<ProduitStock> stockListe, String fichier)

Elle prend en paramètre :

1.	Une liste de produits en stock (List<ProduitStock>)
   
2.	Un chemin de fichier pour enregistrer le PDF

4\Fonctionnement détaillé

 Étapes internes de genererRapportStock(...)
 
1.	Création d’un document PDF via Document document = new Document();
	
2.	Initialisation du writer avec PdfWriter.getInstance(...)
  
3.	Ouverture du document avec document.open()

4.	Ajout d’un titre :
   
document.add(new Paragraph("Rapport de Stock", ...));

5.	Création d’un tableau à 2 colonnes (Produit ID, Quantité)
   
6.	Boucle sur la liste pour remplir les lignes du tableau
  
7.	Fermeture du document

5\Intégration dans l’interface utilisateur

Dans la classe MainAppWithTabs, un bouton PDF est lié à cette fonction :

PdfGenerator.genererRapportStock(stockController.listerStockActuel(), "rapport_stock.pdf");

L'utilisateur peut :

•	Choisir un emplacement

•	Générer le fichier PDF en un clic

•	Retrouver le fichier dans son explorateur

6\Problèmes rencontrés

       Problème	                                        Solution apportée
       
Fichier PDF introuvable  -----------------           Ajout d’un sélecteur de fichier (FileChooser)

Erreur de permission (écriture)	---------------        Vérification des droits + message d'erreur

7\Conclusion

La génération de PDF constitue une valeur ajoutée importante au projet. Elle permet de produire un rapport propre et exportable à tout moment, ce qui est essentiel pour le suivi d’inventaire. L’utilisation de la bibliothèque iText a permis de simplifier la génération sans dépendance externe visuelle. Ce module est 100 % fonctionnel et intégré à l’interface.



   




