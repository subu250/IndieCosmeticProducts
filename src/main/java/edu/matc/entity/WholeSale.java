package edu.matc.entity;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The type Offer.
 */
//@Entity(name = "Offer")
//@Table(name = "offer")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class WholeSale {
    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "user_id"))
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "order_number")
    private int orderNumber;

//    @OneToMany(mappedBy = "order_number", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
//    @ToString.Exclude @EqualsAndHashCode.Exclude private Set<Order> orders = new HashSet<>();

    /**
     * Instantiates a new wholesale.
     *
     * @param user the user
     */
    public WholeSale(User user) {
        this.user = user;
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
//        order.setWholeSale(this);
//    }
//
//    /**
//     * Remove order.
//     *
//     * @param order the order
//     */
//    public void removeOrder(Order order) {
//        orders.remove(order);
//        order.setWholeSale(null);
//    }
}