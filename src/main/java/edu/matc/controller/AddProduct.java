package edu.matc.controller;


import edu.matc.entity.Product;
import edu.matc.entity.external.ProductResponse;
import edu.matc.persistence.GenericDao;
import edu.matc.persistence.external.ProductApiDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
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


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String page = "/productInfo.jsp";
        Product product = new Product();
        String brand = req.getParameter("productBrand");
        String category = req.getParameter("productCategory");
        try {
            setCatalogFields(product, brand, category, req, resp, page);

        } catch (Exception e) {
            logger.error("Unable to add", e);
        } finally {
            forwardDispatcher(req, resp, page);
        }
    }

    private void setCatalogFields(Product product, String brand, String category, HttpServletRequest req,
                                  HttpServletResponse resp, String page) throws ServletException, IOException {
        ProductResponse[] productItems;
        try {
            productItems = getCatalogResponse(brand, category);
            product.setCategory(productItems[0].getProductResponse().get(0).getBrand());
            productDao.insert(product);
            req.setAttribute("product", productItems);
        } catch (Exception e) {
            String errMsg = "Please try again";
            req.setAttribute("product", product);
            logger.error("product: {} {}", product);
            logger.error("exception: {}", e);
            page = "/addProduct.jsp";
            forwardDispatcher(req, resp, page);
        }

    }

    private void forwardDispatcher(HttpServletRequest req, HttpServletResponse resp, String page) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher(page);
        dispatcher.forward(req, resp);
    }

    // get response from Product RESTful API
    private ProductResponse[] getCatalogResponse(String brand, String category) {
        ProductApiDao productApiDao = new ProductApiDao();
        return productApiDao.getCatalogResponse(brand, category);
    }
}