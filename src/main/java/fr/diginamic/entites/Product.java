package fr.diginamic.entites;

import jakarta.persistence.*;
import org.hibernate.annotations.ManyToAny;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Classe de Product
 * Deviendra la Table éponyme dans la BDD petstore
 */
@Entity
@Table(name = "Products" )
public class Product implements Serializable {

    /**ID du product**/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**Code du product**/
    @Column(name = "Code", nullable = false, length = 50)
    private String code;

    /**Label du product**/
    @Column(name = "Label", nullable = false, length = 50)
    private String label;

    /**lien vers ProdType**/
    @Enumerated(EnumType.STRING)
    @Column(name = "Type", nullable = false)
    private ProdType type;

    /**price du product**/
    @Column(name = "Price", nullable = false)
    private double price;

    /**lien vers la table PetStore**/
    @ManyToMany(mappedBy = "products")
    private Set<PetStore> petstore;

    //Instanciation du set déclaré précédemment
    {petstore = new HashSet<PetStore>();}

    /**
     * Constructeur Vide matérialisé pour le papping avec JPA
     */
    public Product() {
    }

    /**
     * Constructeur avec tous les paramètres
     * @param code
     * @param label
     * @param type
     * @param price
     */
    public Product( String code, String label, ProdType type, double price) {

        this.code = code;
        this.label = label;
        this.type = type;
        this.price = price;
    }

    //Setters et Getters

    /**
     * Getter de l'ID
     *
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter de l'ID
     *
     * @param id
     **/
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter du code
     *
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * Setter du code
     *
     * @param code
     **/
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Getter du label
     *
     * @return label
     */
    public String getLabel() {
        return label;
    }

    /**
     * Setter du label
     *
     * @param label
     **/
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Getter du type
     *
     * @return type
     */
    public ProdType getType() {
        return type;
    }

    /**
     * Setter type
     *
     * @param type
     **/
    public void setType(ProdType type) {
        this.type = type;
    }

    /**
     * Getter du price
     *
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Setter du price
     *
     * @param price
     **/
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Ajoute un petstore au set de petstores
     * @param petStore
     */
    public void ajouterPetStore(PetStore petStore) {
        if(petStore != null) {
            this.petstore.add(petStore);
            petStore.getProducts().add(this);
        }

    }

    /**
     * Retire un petstore du set de petstores
     * @param petStore
     */
    public void retirerPetStore(PetStore petStore) {
        if(petStore!= null) {
            this.petstore.remove(petStore);
            petStore.getProducts().remove(this);
        }
    }

    /**Methode ToString**/
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product{");
        sb.append("id=").append(id);
        sb.append(", code='").append(code).append('\'');
        sb.append(", label='").append(label).append('\'');
        sb.append(", type=").append(type);
        sb.append(", price=").append(price);
        sb.append(", petstore=").append(petstore);
        sb.append('}');
        return sb.toString();
    }

    /**Méthode equals**/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(getPrice(), product.getPrice()) == 0 && Objects.equals(getCode(), product.getCode()) && Objects.equals(getLabel(), product.getLabel()) && getType() == product.getType();
    }



    /**
     * Méthode hashCode pour la sérialisation de l'objet en JSON ou XML*'
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(getCode(), getLabel(), getType(), getPrice());
    }
}
