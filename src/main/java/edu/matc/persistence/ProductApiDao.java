package edu.matc.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import product.api.ProductApiItem;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

public class ProductApiDao {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Get products response productsitem [ ].
     *
     * @param brand  the brand
     * @param price the price
     */
    public ProductApiItem[] getProductResponse(String brand, String price) throws IOException {

        Client client = ClientBuilder.newClient();

        String url = "https://makeup-api.herokuapp.com/api/v1/products.json?brand=maybelline";
        WebTarget target = client.target(url);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        ProductApiItem[] productApiResponse = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            productApiResponse = mapper.readValue(response, ProductApiItem[].class);

        } catch (JsonProcessingException e) {
           logger.error("JsonProcessingException" + e);
        }
        return productApiResponse ;
    }
}


