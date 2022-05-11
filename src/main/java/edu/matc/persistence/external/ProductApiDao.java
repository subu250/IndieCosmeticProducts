package edu.matc.persistence.external;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.matc.entity.external.Product;
import edu.matc.entity.external.ProductResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ProductApiDao {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private static final String BASE_URL = "https://makeup-api.herokuapp.com/api/v1/products.json";
    private Client client = ClientBuilder.newClient();

    public List<Product> findByType(String type) {

        WebTarget target = client
                .target(BASE_URL)
                .queryParam("product_type", type);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        Product[] products = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            products = mapper.readValue(response, Product[].class);
        } catch (IOException e) {
            logger.error(e.getStackTrace());
        }
        return Arrays.asList(products);
    }

    public List<Product> find(Map<String, String[]> searchCriteria) {
        WebTarget target = getWebTarget(searchCriteria);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        Product[] products = null;

        ObjectMapper mapper = new ObjectMapper();

        try {
            products = mapper.readValue(response, Product[].class);
        } catch (IOException e) {

        }
        return Arrays.asList(products);
    }

    private WebTarget getWebTarget(Map<String, String[]> queryParams) {
        WebTarget webTarget = client
                .target(BASE_URL);
        if (queryParams != null) {
            for (Map.Entry<String, String[]> queryParameter : queryParams.entrySet()) {
                logger.debug("Filtered products on {} with {}.", queryParameter.getKey(), String.join(",", queryParameter.getValue()));
                webTarget = webTarget.queryParam(queryParameter.getKey(), (Object[]) queryParameter.getValue());
            }

        }
        return webTarget;
    }

    /**
     * Get brand response from catalog [ ].
     *
     * @param brand  the brand
     * @param category the category
     * @return the product response
     */

    public ProductResponse[] getCatalogResponse(String brand, String category) {


        Client client = ClientBuilder.newClient();

        String url = "https://makeup-api.herokuapp.com/api/v1/products.json";
        WebTarget target = client.target(url);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        ProductResponse[] productResponse = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            productResponse = mapper.readValue(response, ProductResponse[].class);

        } catch (JsonProcessingException e) {
            logger.error("JsonProcessingException" + e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productResponse;
    }
}

