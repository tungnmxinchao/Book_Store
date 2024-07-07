/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import dal.BookDAO;
import entity.BookResponse;
import entity.Category;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author TNO
 */
@WebServlet(name = "ViewBookDetails", urlPatterns = {"/bookDetails"})
public class ViewBookDetails extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idBook = Integer.parseInt(request.getParameter("bookId"));

        BookDAO bookDAO = new BookDAO();

        BookResponse book = bookDAO.findBookByID(idBook);

        List<Category> listCategory = bookDAO.findAllCategoryBook();

        request.setAttribute("listCategory", listCategory);

        request.setAttribute("book", book);

        request.getRequestDispatcher("UpdateBook.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
