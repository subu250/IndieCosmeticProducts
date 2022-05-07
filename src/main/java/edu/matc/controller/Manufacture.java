package edu.matc.controller;

import edu.matc.entity.Manufacturer;
import edu.matc.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/mfg"}
)

public class Manufacture extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao<Manufacturer> mfgDao = new GenericDao<Manufacturer>(Manufacturer.class);
        if (req.getParameter("submit").equals("search")) {
            req.setAttribute("manufacturers", mfgDao.getByPropertyEqual("manufacturerName", req.getParameter("searchTerm")));
        } else {
            req.setAttribute("manufacturers", mfgDao.getAll());
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/manufacture.jsp");
        dispatcher.forward(req, resp);

    }
}
