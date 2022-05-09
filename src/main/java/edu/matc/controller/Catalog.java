package edu.matc.controller;

import edu.matc.entity.external.Product;
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
import java.util.List;

@WebServlet(urlPatterns = {"/catalog"})
public class Catalog extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        logger.debug("Fetching products from external RESTful service.");
        ProductApiDao productDao = new ProductApiDao();
        List<Product> products = productDao.find(req.getParameterMap());
        req.setAttribute("products", products);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/catalog.jsp");
        dispatcher.forward(req, resp);
    }
}
