package dal;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Gestion du PersistanceManager
 */
public final class PersistenceManager {

    /**Entity Manager Factory*/
    private static EntityManagerFactory emf;
    /**Constructeur privé pour empêcher l'instanciation de la classe*/
    private PersistenceManager() {
    }

    /**
     * Récupère un EntityManager pour la gestion des entités
     * @return EntityManager
     */
    public static EntityManager getEntityManager() {
        return null;
    }

    /**
     * Crée et retourne un EntityManagerFactory
     * @return emf
     */
    public static EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("petstore");
        }
        return emf;
    }

    /**
     * Ferme le EntityManagerFactory
     */
    public static void closeEntityManagerFactory() {
        if (emf != null) {
            emf.close();
        }
    }
}
