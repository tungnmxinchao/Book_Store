/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import dal.BookDAO;
import entity.BookResponse;
import entity.Users;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author TNO
 */
@WebServlet(name = "PageProductManager", urlPatterns = {"/pageProduct"})
public class PageProductManager extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        Users user = (Users) session.getAttribute("user");
        
        if(user == null || user.getRole() != 2){
            response.sendRedirect("login");
            return;
        }
        
        List<BookResponse> listBook = getListBook(request);

        request.setAttribute("listBook", listBook);
        request.getRequestDispatcher("ProductManager.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private List<BookResponse> getListBook(HttpServletRequest request) {
        BookDAO bookDAO = new BookDAO();

        List<BookResponse> listBook = null;

        String action = request.getParameter("action") == null
                ? "defaultFindAll"
                : request.getParameter("action");
        switch (action) {
            case "search":
                String name = request.getParameter("nameBook");
                listBook = bookDAO.findBookByName(name);
                break;
            default:
                listBook = bookDAO.findAllBook();

        }

        return listBook;
    }

}
