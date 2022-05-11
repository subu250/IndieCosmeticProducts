package edu.matc.controller;

import edu.matc.entity.Product;
import edu.matc.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * A servlet to search products
 *
 * @author subu
 */
@WebServlet(
        urlPatterns = {"/searchProducts"}
)

public class SearchProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao genericDao = new GenericDao(Product.class);
        String searchTerm = req.getParameter("searchTerm");
        if ((searchTerm != "") && (searchTerm != null)) {
            req.setAttribute("products", genericDao.getByPropertyEqual("Brand",req.getParameter("searchTerm")));
        } else {
            req.setAttribute("products", genericDao.getAll());
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/productInfo.jsp");
        dispatcher.forward(req, resp);
    }


}