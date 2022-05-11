package edu.matc.entity.external;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class ProductResponse {
    @JsonProperty("ProductResponse")


    private List<Product> productResponse;

    public void setProductResponse(List<Product> productResponse) {
        this.productResponse = productResponse;
    }

    public List<Product> getProductResponse() {
        return productResponse;
    }

    @Override
    public String toString() {
        return
                "ProductResponse{" +
                        "productResponse = '" + productResponse + '\'' +
                        "}";
    }
}

