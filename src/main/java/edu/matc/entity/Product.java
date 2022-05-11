package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


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
    @Column(name = "brand")
    public String brand;
    @Column(name = "category")
    public String category;
    @Column(name = "price")
    public String price;


    @OneToMany(mappedBy = "product",  fetch = FetchType.EAGER)
    private Set<OrderProduct> orders = new HashSet<OrderProduct>();


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
        this.category = category;
        this.price = price;
        this.brand = brand;

    }

    public Product(String brand, String category) {
    }

    public Product(Integer id, String brand, String category) {
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
    public void setBrand(String brand) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", category=" + category +
                '}';
    }

    public Set<OrderProduct> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrderProduct> orders) {
        this.orders = orders;
    }
}



