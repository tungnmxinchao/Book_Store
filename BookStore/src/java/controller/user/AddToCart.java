/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.user;

import dal.BookDAO;
import entity.BookResponse;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.HashMap;

/**
 *
 * @author TNO
 */
@WebServlet(name = "AddToCart", urlPatterns = {"/addToCart"})
public class AddToCart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idBook = Integer.parseInt(request.getParameter("idBook"));

        BookDAO bookDAO = new BookDAO();
        HttpSession session = request.getSession();

        BookResponse book = bookDAO.findBookByID(idBook);

        HashMap<String, Integer> cartHashMap = (HashMap<String, Integer>) session.getAttribute("cartHashMap");

        String key = book.getIdBook() + " " + book.getName() + " " + book.getPrice();
        int total = cartHashMap.getOrDefault(key, 0);

        cartHashMap.put(key, total + 1);

        session.setAttribute("cartHashMap", cartHashMap);

        response.sendRedirect("cart");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
