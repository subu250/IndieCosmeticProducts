package edu.matc.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * A class to represent a user.
 *
 * @author subu
 */
@Entity(name = "User")
@Table(name = "user")
@Data
public class User {
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int Id;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Order> orders = new HashSet<>();


    /**
     * Gets orders.
     *
     * @return the orders
     */
    public Set<Order> getOrders() {
        return orders;
    }

    /**
     * Sets orders.
     *
     * @param orders the orders
     */
    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    /**
     * Add order.
     *
     * @param order the order
     */
    public void addOrder(Order order) {
        orders.add(order);
        order.setUser(this);
    }

    /**
     * Remove order.
     *
     * @param order the order
     */
    public void removeOrder(Order order) {
        orders.remove(order);
        order.setUser(null);
    }
}