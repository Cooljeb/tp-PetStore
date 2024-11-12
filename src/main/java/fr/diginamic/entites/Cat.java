package fr.diginamic.entites;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

/**
 * classe de chat
 * qui deviendra une entité éponyme dans la bdd petstore
 */
@Entity
@Table(name = "Cat")
public class Cat extends Animal  {


    /**chipId*/
    @Column(name = "ChipId")
    private String chipId;

    /**
     * Constructeur Vide matérialisé pour le papping avec JPA
     */
    public Cat() {
        super();
    }

    /**
     * Constructeur de la classe Cat.
     *
     * @param birth la date de naissance du chat
     * @param couleur la couleur du chat
     * @param chipId l'identifiant de la puce électronique du chat
     */
    public Cat( Date birth, String couleur,  PetStore petstore,String chipId) {
        super(birth, couleur,petstore);
        this.chipId = chipId;
    }

    //Getters et Setters

    /**
     * Renvoie la valeur de {@link #chipId}.
     *
     * @return la valeur actuelle de chipId.
     */
    public String getChipId() {
        return chipId;
    }

    /**
     * Définit la valeur de {@link #chipId}.
     *
     * @param chipId la nouvelle valeur de chipId.
     */
    public void setChipId(String chipId) {
        this.chipId = chipId;
    }

}
