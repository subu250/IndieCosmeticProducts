package edu.matc.controller;

import edu.matc.persistence.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;


/**
 * A simple servlet to welcome the user.
 * @author pwaite
 */

@WebServlet(
        urlPatterns = {"/searchUser"}
)

public class SearchUsers extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserDao dao = new UserDao();
        if (req.getParameter("submit").equals("search")) {
            req.setAttribute("users", dao.getByPropertyLike("lastName", req.getParameter("searchTerm")));
        } else {
            req.setAttribute("users", dao.getAllUsers());
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/userResults.jsp");
        dispatcher.forward(req, resp);
    }
}
