package App;

import dal.PersistenceManager;
import fr.diginamic.entites.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

/**
 * Classe principale de l'application'
 */
public class  App {
    public static void main(String[] args) {

        //Persistence Manager est appelé pour effetcuer les transactions
        EntityManagerFactory emf = PersistenceManager.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        //Création des adresses
        Address paris = new Address("10", "Rue des Martyrs", "Paris", "75001");
        Address nantes = new Address("20", "Rue de la Chasse", "Nantes", "44000");
        Address bordeaux = new Address("30", "Rue des Boules", "Bordeaux", "33000");
        em.persist(paris);
        em.persist(nantes);
        em.persist(bordeaux);


        //création des PetStore
        PetStore petStore = new PetStore("Liope", "Jean Louis", bordeaux);
        PetStore petStore2 = new PetStore("CatFish", "Louis Jean", nantes);
        PetStore petStore3 = new PetStore("FishCat", "Alain Deloin", paris);
        //Insertion des petstores dans la base de données
        em.persist(petStore);
        em.persist(petStore2);
        em.persist(petStore3);

        //Création des Product
        Product product = new Product("Product1", "Produit 1", ProdType.FOOD, 10.0);
        Product product2 = new Product("Product2", "Produit 2", ProdType.CLEANING, 5.0);
        Product product3 = new Product("Product3", "Produit 3", ProdType.ACCESSORY, 2.0);
        //Insertion des produits dans la base de données
        em.persist(product);
        em.persist(product2);
        em.persist(product3);

        //création des animaux
        Cat cat = new Cat(Date.valueOf(LocalDate.now()), "Blanc", petStore, "1234567890");
        Cat cat2 = new Cat(Date.valueOf(LocalDate.now()), "Noir", petStore2, "9876543210");
        Cat cat3 = new Cat(Date.valueOf(LocalDate.now()), "Bleu", petStore3, "0123456789");

        //ajout des animaux aux petstores
        petStore3.ajouterAnimal(cat);
        petStore2.ajouterAnimal(cat2);
        petStore.ajouterAnimal(cat3);
//        //Insertion des animaux dans la base de données

        em.persist(cat);
        em.persist(cat2);
        em.persist(cat3);


        //création des poissons
        Fish fish = new Fish(Date.valueOf(LocalDate.now()), "Rouge", petStore, FishLivEnv.FRESH_WATER);
        Fish fish2 = new Fish(Date.valueOf(LocalDate.now()), "Jaune", petStore2, FishLivEnv.SEA_WATER);
        Fish fish3 = new Fish(Date.valueOf(LocalDate.now()), "Vert", petStore3, FishLivEnv.FRESH_WATER);

        //ajout des poissons aux petstores
        petStore3.ajouterAnimal(fish);
        petStore2.ajouterAnimal(fish2);
        petStore.ajouterAnimal(fish3);

        em.persist(fish);
        em.persist(fish2);
        em.persist(fish3);

        // Mise à jour des PetStore (cela persistera aussi les animaux grâce à CascadeType.ALL)
        em.merge(petStore);
        em.merge(petStore2);
        em.merge(petStore3);



        //ajout des produits aux petstores
        petStore.ajouterProduit(product);
        petStore2.ajouterProduit(product2);
        petStore3.ajouterProduit(product3);

        //Sélection des animaux du shop Liope
        TypedQuery<Animal> query = em.createQuery("select a from Animal a join a.petstore b where b.name= 'Nantes'", Animal.class);
        List<Animal> animauxDuShopLiope = query.getResultList();

        //Validation des différentes transactions
        em.getTransaction().commit();
        em.close();
    }
}
