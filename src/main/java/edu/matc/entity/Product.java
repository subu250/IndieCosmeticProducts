package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;


/**
 * The type Product.
 */
@Entity(name = "Product")
@Table(name = "product")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    private String price;
    private String brand;

    @Column(name = "category")
    private String category;

//   // @ManyToOne
//    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "user_id"))
//    private User user

//    @ManyToOne
//    @JoinColumn(name = "mfg_id", foreignKey = @ForeignKey(name = "mfg_id"))
//    private Manufacturer manufacturer;


//  @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
//  private Set<Manufacturer> manufacturerSet = new HashSet<>();

    /**
     * Instantiates a new Product.
     */
    public Product() {

    }

    /**
     * Instantiates a new Product.
     *
     * @param category the category
     * @param price    the price
     * @param brand    the brand
     */
    public Product(String price, String category, String brand) {
        //this.manufacturer = manufacturer;
        this.category = category;
        this.price = price;
        this.brand = brand;

    }

    /**
     * Sets price of product
     *
     * @param price the price
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * Gets price of product
     *
     * @return price price
     */
    public String getPrice() {
        return price;
    }

    /**
     * Sets brand of product
     *
     * @param brand the brand
     */
    public void setDescription(String brand) {
        this.brand = brand;
    }

    /**
     * Gets brand of product
     *
     * @return brand brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Sets category of product
     *
     * @param category the category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Gets category
     *
     * @return category of product
     */
    public String getCategory() {
        return category;
    }


//    /**
//     * Gets user.
//     *
//     * @return the user
//     */
//    public User getUser() {
//        return user;
//    }
//
//    /**
//     * Sets user.
//     *
//     * @param user the user
//     */
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    /**
//     * Gets manufacturer set.
//     *
//     * @return the manufacturer set
//     */
//    public Set<Manufacturer> getManufacturerSet() {
//        return manufacturerSet;
//    }
//
//    /**
//     * Sets manufacturer set.
//     *
//     * @param manufacturerSet the manufacturer set
//     */
//    public void setManufacturerSet(Set<Manufacturer> manufacturerSet) {
//        this.manufacturerSet = manufacturerSet;


//    /**
//     * Add manufacture.
//     *
//     * @param manufacturer the manufacture
//     */
//    public void addManufacturer(Manufacturer manufacturer) {
//        manufacturerSet.add(manufacturer);
//        manufacturer.(this);
//    }
//
//    /**
//     * Remove manufacture.
//     * @param manufacturer the manufacture
//     */
//    public void removeManufacturerItem(Manufacturer manufacturer) {
//        manufacturerSet.remove(manufacturer);
//        manufacturer.setProduct(null);
//    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
               // ", user=" + user +
                ", category=" + category +
            //  ", manufacturerSet=" + manufacturerSet +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && brand.equals(product.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand);
    }

}




