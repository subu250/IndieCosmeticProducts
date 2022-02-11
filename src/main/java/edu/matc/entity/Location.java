package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * The type Location.
 */
@Entity(name = "Location")
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

   // @NotEmpty
    private String city;

   // @NotEmpty
   // @Size(min = 2, max = 2, message = "must be two digits")
    private String state;
    private String zipCode;
    private String county;

    @ManyToOne
    private Product product;

    /**
     * Instantiates a new Location.
     */
    public Location() {
    }

    /**
     * Instantiates a new Location.
     *
     * @param city    the city
     * @param product the product
     */
    public Location(String city, Product product) {
        this.city = city;
        this.product = product;
    }

    /**
     * Instantiates a new Location.
     *
     * @param city    the city
     * @param state   the state
     * @param zipCode the zip code
     * @param county  the county
     * @param product the product
     */
    public Location(String city, String state, String zipCode, String county, Product product) {
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.county = county;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;


    }
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", county='" + county + '\'' +
                ", product=" + product +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location that = (Location) o;
        return id == that.id && Objects.equals(city, that.city) && Objects.equals(state, that.state) && Objects.equals(zipCode, that.zipCode) && Objects.equals(county, that.county) &&  Objects.equals(product, that.product);    }

    @Override
    public int hashCode() {
        return Objects.hash(id, city, state, zipCode, county, product);
    }
}



