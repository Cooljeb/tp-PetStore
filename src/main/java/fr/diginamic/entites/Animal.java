package fr.diginamic.entites;

import jakarta.persistence.*;
import jdk.jfr.Enabled;

import java.io.Serializable;
import java.util.Date;


/**
 * Classe Animal
 * Deviendra la Table éponyme dans la BDD petstore
 */
@Entity
@Table(name = "Animal")
@Inheritance(strategy = InheritanceType.JOINED)
public class Animal implements Serializable {

    /**ID de l'animal**/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**date de naissance de l'animal**/
    @Column(name = "Birthday",nullable = false )
    private Date birth;

    /**couleur de l'animal**/
    @Column(name = "Couleur", nullable = false , length = 50)
    private String couleur;


    /**propriété {@link PetStore}**/
    @ManyToOne
    @JoinColumn(name = "id_P",referencedColumnName = "id",nullable = false)
    private PetStore petstore;



    /**
     * Constructeur Vide matérialisé pour le papping avec JPA
     */
    public Animal() {
    }

    /**
     * Constructeur avec les paramètres

     * @param birth
     * @param couleur
     * @param petstore
     */
    public Animal( Date birth, String couleur, PetStore petstore) {
        this.birth = birth;
        this.couleur = couleur;
        setPetstore(petstore);
    }

    //Getters et Setters

    public Long getId() {
        return id;
    }

    /**
     * Setter de l'id
     *
     * @param id
     **/
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter de la date de naissance
     *
     * @return birth
     */
    public Date getBirth() {
        return birth;
    }

    /**
     * Setter de la date de naissance
     *
     * @param birth
     **/
    public void setBirth(Date birth) {
        this.birth = birth;
    }

    /**
     * Getter de la couleur
     *
     * @return couleur
     */
    public String getCouleur() {
        return couleur;
    }

    /**
     * Setter de la couleur
     *
     * @param couleur
     **/
    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    /**
     * Définit la valeur de la propriété petstore.
     *
     * @param petstore la nouvelle valeur de petstore
     * Avec les tests de création et ou ajout dans Set d'animals
     */
    public void setPetstore(PetStore petstore) {
        if(this.petstore!=null) {
            this.petstore.getAnimaux().remove(this); //si le petstore est déjà connu, on supprime le petstore existant
        }
        this.petstore = petstore;

        if(this.petstore!=null) {
            this.petstore.getAnimaux().add(this);// dans  ce cas il n'est pas existant et on l'ajoute
        }
    }

    /**
     * Récupère la valeur de la propriété petStore.
     *
     * @return la valeur de petStore
     */
    public PetStore getPetStore() {
        return petstore;
    }
    /**méthode toString**/
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Animal{");
        sb.append("birth=").append(birth);
        sb.append(", couleur='").append(couleur).append('\'');
        sb.append(", petstore=").append(petstore);
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}
