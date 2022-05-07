package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


/**
 * The type Product.
 */
@Entity(name = "Product")
@Table(name = "product")

public class Product {

    private String price;
    private String brand;



    @Column(name = "category")
    private String category;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "user_id"))
    private User user;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "product_id")
    private int productId;

//    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
//  //  private Set<Order> orders = new HashSet<>();

    /**
     * Instantiates a new Product.
     */
    public Product() {

    }

    /**
     * Instantiates a new Product.
     *
     * @param category the category
     * @param user     the user
     * @param price    the price
     * @param brand the brand
     */
    public Product(User user, String price, String category, String brand) {
        this.user = user;
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


    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

//    /**
//     * Add order.
//     *
//     * @param order the order
//     */
//    public void addOrder(Order order) {
//        orders.add(order);
//        order.setProduct(this);
//    }
//
//    /**
//     * Remove orderItem.
//     *
//     * @param order the orderItem
//     */
//    public void removeOrderItem(Order order) {
//        orders.remove(order);
//        order.setProduct(null);
//    }

}
