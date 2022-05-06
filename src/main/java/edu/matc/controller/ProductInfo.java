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
 * A servlet to view product information
 *
 * @author pwaite
 */
@WebServlet(
        urlPatterns = {"/productInfo"}
)

public class ProductInfo extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao genericDao = new GenericDao(Product.class);
        int id = (Integer.parseInt(req.getParameter("brand")));
        String page = "/productInfo.jsp";
        try {
            Product productInfo = (Product) genericDao.getById(id);
            logger.debug("The productInfo: {}", productInfo);
            req.setAttribute("productInfo", productInfo);
        } catch (Exception e ){
            page = "/error.jsp";
            logger.error("Error retrieving Product Info", e);
        } finally {
            RequestDispatcher dispatcher = req.getRequestDispatcher(page);
            dispatcher.forward(req, resp);
        }
    }

}

