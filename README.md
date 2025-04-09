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

•	Modèle (MouvementStock) : Contient les informations d'un mouvement de stock, telles que le produit, le type de mouvement (entrée ou sortie), la quantité et la date du mouvement.
