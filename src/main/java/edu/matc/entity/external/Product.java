package edu.matc.entity.external;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Product {

    @JsonProperty("website_link")
    private String websiteLink;

    @JsonProperty("image_link")
    private String imageLink;

    @JsonProperty("rating")
    private double rating;

    @JsonProperty("description")
    private String description;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("api_featured_image")
    private String apiFeaturedImage;

    @JsonProperty("product_type")
    private String productType;

    @JsonProperty("updated_at")
    private String updatedAt;

    @JsonProperty("price")
    private String price;

    @JsonProperty("tag_list")
    private List<Object> tagList;

    @JsonProperty("name")
    private String name;

    @JsonProperty("price_sign")
    private Object priceSign;

    @JsonProperty("currency")
    private Object currency;

    @JsonProperty("id")
    private int id;

    @JsonProperty("category")
    private Object category;

    @JsonProperty("product_colors")
    private List<ProductColor> productColors;

    @JsonProperty("brand")
    private String brand;

    @JsonProperty("product_api_url")
    private String productApiUrl;

    @JsonProperty("product_link")
    private String productLink;
}
