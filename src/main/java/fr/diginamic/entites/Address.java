package fr.diginamic.entites;

import jakarta.persistence.*;

import java.io.Serializable;

/**
 * Classe matérialisant l'adresse
 * Deviendra la Table éponyme dans la BDD petstore
 */
@Entity
@Table(name = "Address")
public class Address implements Serializable {

    /**ID de l'adresse**/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**numéro de l'adresse**/
    private String number;

    /**rue**/
    private String street;

    /**codePostal**/
    private String zipCode;

    /**ville**/
    private String city;

    /**lien vers Petstore**/
    @OneToOne
    @JoinColumn(name = "id_Pets")
    private PetStore petStore;

    /**
     * Constructeur Vide matérialisé pour le papping avec JPA
     */
    public Address() {
    }
    /**
     * Constructeur avec tous les paramètres
     *
     * @param number      numéro de l'adresse
     * @param street      rue
     *@param zipCode     code postal
     * @param city        ville
     **/

    public Address(String number, String street, String zipCode, String city) {
        this.number = number;
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
    }

    //getters et setters

    /**
     * Getter de l'id
     *
     * @return id
     */
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
     * Getter du numéro
     *
     * @return number
     */
    public String getNumber() {
        return number;
    }

    /**
     * Setter du numéro
     *
     * @param number
     **/
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * Getter de la rue
     *
     * @return street
     */
    public String getStreet() {
        return street;
    }

    /**
     * Setter de la rue
     *
     * @param street
     **/
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Getter du code postal
     *
     * @return zipCode
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Setter code postal
     *
     * @param zipCode
     **/
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Getter de la ville
     *
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * Setter de la ville
     *
     * @param city
     **/
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Récupère la valeur de la propriété petstore.
     *
     * @return la valeur de petstore
     */
    public PetStore getPetStore() {
        return petStore;
    }

    /**
     * Définit la valeur de la propriété petStore.
     *
     * @param petStore la nouvelle valeur de petStore
     */
    public void setPetStore(PetStore petStore) {
        this.petStore = petStore;
    }
}
