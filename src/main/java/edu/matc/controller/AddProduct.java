package edu.matc.controller;


import edu.matc.entity.external.Product;
import edu.matc.persistence.GenericDao;
import edu.matc.persistence.external.ProductApiDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import product.api.ProductResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * A servlet to add product
 */

@WebServlet(
        urlPatterns = {"/addProduct"}
)
public class AddProduct extends HttpServlet {
    GenericDao productDao = new GenericDao(Product.class);
    private final Logger logger = LogManager.getLogger(this.getClass());


    private void setCatalogFields(edu.matc.entity.Product product, String brand, String category, HttpServletRequest req,
                                  HttpServletResponse resp) throws ServletException, IOException {
        ProductResponse[] productItems;
        try {
            productItems = getProductResponse(brand, category);
        } catch (Exception e) {
            String errMsg = "Please try again";
            req.setAttribute("product", product);
            logger.error("product: {} {}",  product);
            logger.error("exception: {}", e);

        }
    }
    private ProductResponse[] getProductResponse(String brand, String category) {
        ProductApiDao productApiDao = new ProductApiDao();
        return getProductResponse(brand, category);
    }
}