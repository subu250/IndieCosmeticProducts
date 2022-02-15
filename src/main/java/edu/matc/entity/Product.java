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


        @Column(name = "product_brand")
        private String brand;

        @ManyToOne
        private User user;

        @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
        private Set<Location> locationSet = new HashSet<>();

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
         * @param type the type
         */
        public Product(String type) {
            this.brand = brand;
        }

        /**
         * Instantiates a new Product.
         *
         * @param id   the id
         * @param brand the brand
         */
        public Product(int id, String brand) {
            this.id = id;
            this.brand = brand;
        }

        /**
         * Instantiates a new Product.
         *
         * @param brand the brand
         * @param user the user
         */
        public Product(String brand, User user) {
            this.brand = brand;
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
        public String getBrand() {
            return brand;
        }

        /**
         * Sets brand.
         *
         * @param brand the brand
         */
        public void setBrand(String brand) {
            this.brand = brand;
        }

        /**
         * Gets location set
         *
         * @return the location set
         */
        public Set<Location> getLocationSet() {
            return locationSet;
        }

        /**
         * Sets location set
         *
         * @param locationSet the location set
         */
        public void setLocationSet(Set<Location> locationSet) {
            this.locationSet = locationSet;
        }

        /**
         * Add shop.
         *
         * @param location the location
         */
        public void addLocation(Location location) {
            locationSet.add(location);
            location.setProduct(this);
        }

        /**
         * Remove shop.
         *
         * @param location the location
         */
        public void removeLocation(Location location) {
            locationSet.remove(location);
            location.setProduct(null);
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
                    ", brand='" + brand + '\'' +
                    ", user=" + user +
                    ", locationSet=" + locationSet +
                    ", offerSet=" + offerSet +
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

