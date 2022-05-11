package edu.matc.controller;

import edu.matc.entity.Product;
import edu.matc.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Add or edit the product
 * @author pwaite
 */

@WebServlet(
        urlPatterns = {"/deleteProduct"}
)
public class DeleteProduct extends HttpServlet {

@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao productDao = new GenericDao(Product.class);
        Product product = new Product();
        product.setId(Integer.valueOf(req.getParameter("id")));
        productDao.delete(product);
        RequestDispatcher dispatcher = req.getRequestDispatcher("searchProducts?searchTerm=&submit=viewAll");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}

