package product.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ProductResponse {


    @JsonProperty("ProductResponse")
    private List<ProductApiItem> productResponse;

    public void setProductResponse(List<ProductApiItem> productResponse){
        this.productResponse = productResponse;
    }

    public List<ProductApiItem> getProductResponse(){
        return productResponse;
    }

    @Override
    public String toString(){
        return
                "ProductResponse{" +
                        "productResponse = '" + productResponse + '\'' +
                        "}";
    }
}



