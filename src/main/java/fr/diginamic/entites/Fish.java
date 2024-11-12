package fr.diginamic.entites;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

/**
 * Classe poisson qui hérite d'animal
 * Deviendra un entité éponyme selon le choix ed conception pur JPA
 */
@Entity
@Table(name = "Fish")
public class Fish extends Animal  {


    /**lieu d'habitat du poisson*/
    @Column(name = "livingEnv")
    private FishLivEnv livingEnv;

    /**Constructeur**/
    public Fish() {

    }

    /**
     * Constructeur avec paramètres

     * @param birth
     * @param couleur
     * @param livingEnv
     */
    public Fish(Date birth,String couleur, PetStore petStore,FishLivEnv livingEnv ) {
        super(birth,couleur,petStore);
        this.livingEnv= livingEnv;
    }

    /**
     * Renvoie la valeur de {@link #livingEnv}.
     *
     * @return la valeur actuelle de livingEnv.
     */
    public FishLivEnv getLivingEnv() {
        return livingEnv;
    }

    /**
     * Définit la valeur de {@link #livingEnv}.
     *
     * @param livingEnv la nouvelle valeur de livingEnv.
     */
    public void setLivingEnv(FishLivEnv livingEnv) {
        this.livingEnv = livingEnv;
    }

    /**
     * Méthode toString
     * @return sb.toString()
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Fish{");
        sb.append("livingEnv=").append(livingEnv);
        sb.append('}');
        return sb.toString();
    }
}
