package edu.matc.controller;

import edu.matc.entity.Product;
import edu.matc.persistence.GenericDao;
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
 * A servlet to retrieve edit form.
 *
 * @author subu
 */

@WebServlet(
        urlPatterns = {"/editProduct"}
)

public class EditProduct extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao productDao = new GenericDao(Product.class);

        if (req.getParameter("id").equals("")) {
            Product product = new Product(req.getParameter("brand"), req.getParameter("category"));
            productDao.insert(product);
        } else {
            Product product = new Product(Integer.valueOf(req.getParameter("id")), req.getParameter("brand"), req.getParameter("category"));

            productDao.saveOrUpdate(product);
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("searchUser?searchTerm=&submit=viewAll");
        dispatcher.forward(req, resp);

    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao productDao = new GenericDao(Product.class);
      //  req.setAttribute("product", productDao.getById(req.getParameter("id")));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/edit.jsp");
        dispatcher.forward(req, resp);
    }
}



