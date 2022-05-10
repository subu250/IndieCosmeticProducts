package edu.matc.entity;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * The type Order.
 */
@Entity(name = "Order")
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    private String description;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    private Set<OrderProduct> products = new HashSet<OrderProduct>();

    /**
     * Instantiates a new Order.
     */
    public Order() {
    }

    /**
     * Instantiates a new Order.
     *
     * @param description the description
     * @param user        the user
     */
    public Order(String description, User user) {
        this.user = user;
        this.description = description;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
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

    /**
     * Gets products.
     *
     * @return OrderProducts related to this Order, which ultimately allows retrieval of the order's products
     */
    public Set<OrderProduct> getProducts() {
        return products;
    }

    /**
     * Sets products.
     *
     * @param products OrderProducts related to this order
     */
    public void setProducts(Set<OrderProduct> products) {
        this.products = products;
    }

    /**
     * Add product.
     *
     * @param product the product to add to the order
     */
    public void addProduct(Product product) {
        OrderProduct orderProduct = new OrderProduct(this, product);
        products.add(orderProduct);
        product.getOrders().add(orderProduct);
    }

    /**
     * Remove product.
     *
     * @param product the product to be removed from the order
     */
    public void removeProduct(Product product) {
        for (Iterator<OrderProduct> iterator = products.iterator();
             iterator.hasNext(); ) {
            OrderProduct orderProduct = iterator.next();

            if (orderProduct.getProduct().equals(this) &&
                    orderProduct.getOrder().equals(product)) {
                iterator.remove();
                orderProduct.getProduct().getOrders().remove(orderProduct);
                orderProduct.setProduct(null);
                orderProduct.setOrder(null);
            }
        }
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", user=" + user +
                ", products=" + products +
                '}';
    }
}