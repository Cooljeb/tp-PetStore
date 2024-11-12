Joseph BROU

Réalisaiton de l'application de gestion du petstore

Réalisation des classes/entités de l'application situées dans le package Entités
Address=> Adresse des Petstore
Animal => Classe Mère des Poisson et Chats (par exemple)

Ces Entitéss permettent la création des tables de la base de données (bdd) petstore

JPA a permis de mapper ces tables => les détails de choix de relation sont basées sur le cahier des charges fournis
pour plus de détail se référer au schéma du TP et aux commentaires présents dans les classe


le package DAl, permet d'utiliser l'entityManager et entityManagerFactory pour effectuer des transactions avec la bdd

le package APP permet de lancer l'application

=>Création des Adresses Trois objets Address sont créés avec des détails de localisation (numéro, rue, ville, code postal)
=>Création des PetStores Trois magasins sont créés avec un nom, un manager, et une adresse associée
=>Création de Produits Trois produits avec des types différents (nourriture, nettoyage, accessoire)
=>Création et ajout des Animaux

	Chats (Cat) : Trois chats sont créés avec des caractéristiques (couleur, numéro de puce, et PetStore associé) et sont ajoutés aux 	PetStores respectifs.
	Poissons (Fish) : Trois poissons sont créés avec leur couleur, leur environnement de vie (eau douce ou eau de mer) et associés à 	leurs PetStores.

=>La méthode ajouterAnimal s’assure que la relation est bien établie dans les deux sens (PetStore -> Animal et Animal -> PetStore).

Ajout des produits aux PetStores

Chaque PetStore reçoit des produits via ajouterProduit, qui assure la relation bidirectionnelle (PetStore -> Product et Product -> PetStore).
Cela permet de lier chaque produit au PetStore, simplifiant les inventaires par magasin.

Requête pour récupérer les animaux d’un magasin spécifique La requête suivante permet de récupérer tous les animaux pour un magasin situé à Nantes

Validation et fermeture de la transaction Après avoir ajouté toutes les entités et exécuté les relations, la transaction est validée par em.getTransaction().commit() et l’EntityManager est fermé.
Cela garantit que toutes les données sont correctement enregistrées en base.

Dans le package ressources, nous retrouvons le fichier persistence, sur lequel s'appuis JPA pour communiquer avec la bdd de type MariaDB

Dans le POM.XML sont ajoutés les dépendances nécessaires pour faire fonctionner ce projet :
=> la dépendance vers le driver MariaDB pour Java
=> la dépendance vers le Hibernate pour la persistence des données

