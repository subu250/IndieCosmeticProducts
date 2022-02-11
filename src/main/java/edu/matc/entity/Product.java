package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

    /**
     * The type Product.
     */
    @Entity(name = "Product")
    @Table(name = "products")
    public class Product {


        @Id
        @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
        @GenericGenerator(name = "native", strategy = "native")
        private int id;


        @Column(name = "product_name")
        private String name;

        @ManyToOne
        private User user;

        @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
        private Set<Location> shopSet = new HashSet<>();

        @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
        private Set<Offer> offerSet = new HashSet<>();


        /**
         * Instantiates a new Product.
         */
        public Product() {
        }

        /**
         * Instantiates a new Product.
         *
         * @param name the name
         */
        public Product(String name) {
            this.name = name;
        }

        /**
         * Instantiates a new Product.
         *
         * @param id   the id
         * @param name the name
         */
        public Product(int id, String name) {
            this.id = id;
            this.name = name;
        }

        /**
         * Instantiates a new Product.
         *
         * @param name the name
         * @param user the user
         */
        public Product(String name, User user) {
            this.name = name;
            this.user = user;
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
         * Gets name.
         *
         * @return the name
         */
        public String getName() {
            return name;
        }

        /**
         * Sets name.
         *
         * @param name the name
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * Gets shop set
         *
         * @return the shop set
         */
        public Set<Location> getShopSet() {
            return shopSet;
        }

        /**
         * Sets shop set
         *
         * @param shopSet the shop set
         */
        public void setShopSet(Set<Location> shopSet) {
            this.shopSet = shopSet;
        }

        /**
         * Add shop.
         *
         * @param shop the shop
         */
        public void addShop(Location shop) {
            shopSet.add(shop);
            shop.setProduct(this);
        }

        /**
         * Remove shop.
         *
         * @param shop the shop
         */
        public void removeShop(Location shop) {
            shopSet.remove(shop);
            shop.setProduct(null);
        }

        /**
         * Gets offer set.
         *
         * @return the offer set
         */
        public Set<Offer> getOfferSet() {
            return offerSet;
        }

        /**
         * Sets offer set.
         *
         * @param offerSet the offer set
         */
        public void setOfferSet(Set<Offer> offerSet) {
            this.offerSet = offerSet;
        }

        /**
         * Add note.
         *
         * @param newOffer the new offer
         */
        public void addOffer(Offer newOffer) {
           offerSet.add(newOffer);
            newOffer.setProduct(this);
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

        @Override
        public String toString() {
            return "Product{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", user=" + user +
                    ", shopSet=" + shopSet +
                    ", offerSet=" + offerSet +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Product product = (Product) o;
            return id == product.id && name.equals(product.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }

    }

