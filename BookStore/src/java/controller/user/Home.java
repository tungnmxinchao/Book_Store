/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.user;

import dal.BookDAO;
import entity.BookResponse;
import entity.Category;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author TNO
 */
@WebServlet(name = "Home", urlPatterns = {"/home"})
public class Home extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        BookDAO bookDAO = new BookDAO();

        HashMap<String, Integer> cartHashMapSession = (HashMap<String, Integer>) session.getAttribute("cartHashMap");

        if (cartHashMapSession == null || cartHashMapSession.isEmpty()) {
            HashMap<String, Integer> cartHashMap = new HashMap<>();
            session.setAttribute("cartHashMap", cartHashMap);
        }

        List<BookResponse> listBook = getListBook(request);
        
        List<Category> listCategory = bookDAO.findAllCategoryBook();
        
        request.setAttribute("listCategory", listCategory);
        request.setAttribute("listBook", listBook);
        request.getRequestDispatcher("index.jsp").forward(request, response);
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
                String name = request.getParameter("bookName");
                listBook = bookDAO.findBookByName(name);
                break;
            case "category":
                int categoryRequest = Integer.parseInt(request.getParameter("categoryID"));
                listBook = bookDAO.findAllBookByCategory(categoryRequest);
                break;
            default:
                listBook = bookDAO.findAllBook();

        }

        return listBook;
    }

}
