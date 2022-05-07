package edu.matc.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


/**
 * A class to represent Order.
 */
@Entity(name = "Order")
@Table(name = "order")
@Getter @Setter @NoArgsConstructor
@ToString @EqualsAndHashCode
public class Order {
    //@ManyToOne
    @JoinColumn(name = "order_number", foreignKey = @ForeignKey(name = "order_number"))
    //private WholeSale wholeSale;

    @ManyToOne
    @JoinColumn(name = "order_id", foreignKey = @ForeignKey(name = "order_id"))
    private Product product;

    @Column(name = "quantity")
    private int quantity;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "id")
    private int id;


    /**
     * Instantiates a new Order.
     * @param quantity   the quantity
     * @param product    the product
     * @param wholeSale    the wholeSale
     */
    public Order(Product product,  int quantity, WholeSale wholeSale) {
        this.quantity = quantity;
        this.product = product;
       // this.wholeSale = wholeSale;
    }

}