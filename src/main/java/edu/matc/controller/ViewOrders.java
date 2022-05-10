package edu.matc.controller;

import edu.matc.entity.Order;
import edu.matc.entity.User;
import edu.matc.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@WebServlet(
        urlPatterns = {"/viewOrders"}
)

public class ViewOrders extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        GenericDao orderDao = new GenericDao(Order.class);
        GenericDao userDao = new GenericDao(User.class);
        int userId = 0;
        Set<Order> orderSet;
        String page = "/orders.jsp";

        // get the userName
        String userName = req.getParameter("userName");
        try {
            List<User> allUsers = new ArrayList<>(userDao.getAll());
            for (User user : allUsers) {
                if (user.getUserName().equals(userName)) {
                    userId = user.getId();
                }
            }
            // get the User and orders
            User user = (User) userDao.getById(userId);
            orderSet = user.getOrders();
            req.setAttribute("orders", orderSet);
            session.setAttribute("userId", userId);
            session.setAttribute("userName", userName);
        } catch (Exception e) {
            page = "/error.jsp";
            logger.error("Error retrieving user ", e);
        } finally {
            RequestDispatcher dispatcher = req.getRequestDispatcher(page);
            dispatcher.forward(req, resp);
        }
    }
}

