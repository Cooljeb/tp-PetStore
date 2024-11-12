package fr.diginamic.entites;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Classe PetStore
 * Deviendra la Table éponyme dans la BDD petstore
 */
@Entity
@Table(name = "PetStore")
public class PetStore implements Serializable {

    /**
     * ID du petstore
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * nom du petstore
     */
    @Column(name = "Name", nullable = false, length = 50)
    private String name;

    /**
     * nom du manager
     **/
    @Column(name = "Manager_Name", nullable = false, length = 50)
    private String managerName;

    /**
     * Tableau des animaux relation avec cette table de la bdd
     **/
    @OneToMany(mappedBy = "petstore",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Animal> animaux;
    //instanciation du tableau de Petstore
    {
        animaux = new HashSet<>();
    }

    /**
     * lien vers adresse
     **/
    @OneToOne
    private Address address;

    /**
     * lien vers la table Products
     **/

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="PetsProducts",
            joinColumns= @JoinColumn(name = "PetStore_Id",referencedColumnName = "id"),
            inverseJoinColumns=@JoinColumn(name = "Products_Id", referencedColumnName = "id")
    )
    private Set<Product> products;
    //instanciation du tableau de Products
    {
        products = new HashSet<>();
    }





    /**
     * Constructeur Vide matérialisé pour le papping avec JPA
     */
    public PetStore() {

    }

    public PetStore(String name, String managerName, Address address) {
        this.name = name;
        this.managerName = managerName;
        this.address = address;
    }

    //Getters et Setters


    /**
     * Renvoie la valeur de {@link #id}.
     *
     * @return la valeur actuelle de id.
     */
    public Long getId() {
        return id;
    }

    /**
     * Définit la valeur de {@link #id}.
     *
     * @param id la nouvelle valeur de id.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Renvoie la valeur de {@link #name}.
     *
     * @return la valeur actuelle de name.
     */
    public String getName() {
        return name;
    }

    /**
     * Définit la valeur de {@link #name}.
     *
     * @param name la nouvelle valeur de name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Renvoie la valeur de {@link #managerName}.
     *
     * @return la valeur actuelle de managerName.
     */
    public String getManagerName() {
        return managerName;
    }

    /**
     * Définit la valeur de {@link #managerName}.
     *
     * @param managerName la nouvelle valeur de managerName.
     */
    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    /**
     * Renvoie la valeur de {@link #animaux}.
     *
     * @return la valeur actuelle de animaux.
     */
    public Set<Animal> getAnimaux() {
        return animaux;
    }

    /**
     * Définit la valeur de {@link #animaux}.
     *
     * @param animaux la nouvelle valeur de animaux.
     */
    public void setAnimaux(Set<Animal> animaux) {
        this.animaux = animaux;
    }

    /**
     * Renvoie la valeur de {@link #address}.
     *
     * @return la valeur actuelle de address.
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Définit la valeur de {@link #address}.
     *
     * @param address la nouvelle valeur de address.
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Renvoie la valeur de {@link #products}.
     *
     * @return la valeur actuelle de products.
     */
    public Set<Product> getProducts() {
        return products;
    }

    /**
     * Définit la valeur de {@link #products}.
     *
     * @param products la nouvelle valeur de products.
     */
    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    /**
     * Méthode pour ajouter un animal à la collection
     *
     * @param animal
     */
    public void ajouterAnimal(Animal animal) {
        if (animal != null) {
            // Ajout de l'animal dans la collection
            animaux.add(animal);

            // Définition du petstore de l'animal
            animal.setPetstore(this);
        }
    }

    public void retirerAnimal(Animal animal) {
        if (animal!= null) {
            // Suppression de l'animal dans la collection
            this.animaux.remove(animal);

            // Définition du petstore à null pour l'animal
            animal.setPetstore(null);
        }
    }

    /**
     * Méthode pour ajouter un produit à la collection
     *
     * @param product
     */
    public void ajouterProduit(Product product) {
        if (product != null) {
            product.ajouterPetStore(this);
        }
    }

    public void retirerProduit(Product product) {
        if (product!= null) {
            product.retirerPetStore(this);
        }
    }
}
