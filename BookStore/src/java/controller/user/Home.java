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

        HashMap<String, Integer> cartHashMapSession = (HashMap<String, Integer>) session.getAttribute("cartHashMap");

        if (cartHashMapSession == null || cartHashMapSession.isEmpty()) {
            HashMap<String, Integer> cartHashMap = new HashMap<>();
            session.setAttribute("cartHashMap", cartHashMap);
        }

        List<BookResponse> listBook = getListBook(request);

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
                List<BookResponse> getAllBooks = bookDAO.findAllBook();
                String name = request.getParameter("name");

                listBook = findBookByName(getAllBooks, name);
                break;
            case "category":
                int categoryRequest = Integer.parseInt(request.getParameter("category"));
                listBook = bookDAO.findAllBookByCategory(categoryRequest);
                break;
            default:
                listBook = bookDAO.findAllBook();

        }

        return listBook;
    }

    private List<BookResponse> findBookByName(List<BookResponse> getAllBooks, String name) {
        List<BookResponse> listSearch = new ArrayList<>();

        for (BookResponse book : getAllBooks) {
            if (name.toLowerCase().contains(book.getName().toLowerCase())) {
                listSearch.add(book);
            }
        }

        return listSearch;
    }

}
