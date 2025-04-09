# App-GSTK
Nom de l’étudiant : Mohammed Achoch

Fonctionnalité : Gestion des entrées et sorties de stock

Objectif :
L'objectif de cette branche était de développer une application permettant de gérer les entrées et sorties de stock d'un produit au sein d'une base de données stockdb. Cette gestion inclut l'enregistrement des mouvements de stock (ajouts et sorties de produits) et l'affichage des mouvements effectués.

Technologies Utilisées :

1.	Java : Langage de programmation principal pour l'implémentation de la logique de l'application.
2.	MySQL : Système de gestion de base de données relationnelle (SGBD) utilisé pour stocker et gérer les données.
3.	JDBC (Java Database Connectivity) : Interface utilisée pour connecter Java à MySQL et effectuer des opérations sur la base de données.
   
Architecture du Projet :

Le projet a été structuré en plusieurs couches pour garantir une séparation claire des responsabilités :

•	Modèle (MouvementStock) : Contient les informations d'un mouvement de stock, telles que le produit, le type de mouvement (entrée ou sortie), la quantité et la date du mouvement.(Voir Fichier MouvementStock.java)

•	DAO (Data Access Object) (StockDAO) : Classe responsable de l'accès aux données. Elle permet d'interagir avec la base de données en exécutant des requêtes SQL pour ajouter, récupérer ou mettre à jour des informations sur les mouvements de stock. (Voir Fichier StockDAO.java)

•	Contrôleur (StockController) : Gère la logique métier, comme l'ajout de mouvements et la validation des entrées. Cette classe assure également l'interaction entre le modèle et le DAO. (Voir Fichier StockController.java)

Fonctionnalités Implémentées

1.	Ajout de Mouvements : L'application permet d'ajouter des mouvements de stock (entrées ou sorties). Un mouvement est caractérisé par un produitId, un type (ENTREE ou SORTIE) et une quantité.

2.	Vérification des Quantités : Avant d'ajouter une sortie de stock, l'application vérifie que la quantité disponible est suffisante.

3.	Affichage des Mouvements : Une fois qu'un mouvement est effectué, il peut être consulté dans la base de données. Un utilisateur peut récupérer tous les mouvements enregistrés pour un produit donné.

Processus de Développement:

1.	Création de la Base de Données : La base de données stockdb a été créée avec une table produit pour les produits stockés, et une table mouvement_stock pour enregistrer les mouvements (entrées et sorties) des produits.

2.	Modélisation des Données :

o	Produit : La table produit contient les informations de chaque produit, telles que l'ID, le nom, la quantité et le prix.

o	Mouvement de Stock : La table mouvement_stock enregistre les mouvements de stock avec un identifiant unique, l'ID du produit, le type de mouvement (ENTREE ou SORTIE), la quantité et la date du mouvement.

3.	Connexion à la Base de Données : Une connexion à la base de données MySQL a été établie à l'aide du connecteur JDBC pour exécuter des requêtes SQL.

4.	Ajout de Mouvements : Lorsqu'un mouvement est ajouté via l'application, une entrée est insérée dans la table mouvement_stock. Si le mouvement est une entrée, la quantité du produit est augmentée, et si c'est une sortie, la quantité est diminuée.

Conclusion:

Le projet de gestion des entrées et sorties de stock est désormais opérationnel. Il permet d'ajouter des produits, de gérer les mouvements de stock (entrées et sorties), et de récupérer les informations relatives aux mouvements effectués. Les vérifications de validité (quantité suffisante pour une sortie, types de mouvement corrects) garantissent que l'application fonctionne de manière fiable et sécurisée.
