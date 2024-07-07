/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.user;

import entity.CartBook;
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
import java.util.Map;
import utils.GetDataUtils;

/**
 *
 * @author TNO
 */
@WebServlet(name = "PageCart", urlPatterns = {"/pageCart"})
public class PageCart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<CartBook> listCart = new ArrayList<>();

        HashMap<String, Integer> cartHashMap = (HashMap<String, Integer>) session.getAttribute("cartHashMap");
        int totalAllCart = 0;

        for (Map.Entry<String, Integer> entry : cartHashMap.entrySet()) {
            String[] key = entry.getKey().split(" ");
            String idBook = key[0];
            String bookPrice = key[key.length - 1];

            StringBuilder bookNameBuilder = new StringBuilder();
            for (int i = 1; i < key.length - 1; i++) {
                bookNameBuilder.append(key[i]);
                if (i < key.length - 2) {
                    bookNameBuilder.append(" ");
                }
            }

            String nameOfBook = bookNameBuilder.toString();

            int quantity = entry.getValue();

            int totalEachBook = quantity * GetDataUtils.parseVietnamCurrency(bookPrice);

            totalAllCart += totalEachBook;

            CartBook cartBook = new CartBook(idBook, nameOfBook, bookPrice,
                    GetDataUtils.formatToVietnamCurrency(totalEachBook), quantity);

            listCart.add(cartBook);
        }

        request.setAttribute("listCart", listCart);
        request.setAttribute("totalAllCart", GetDataUtils.formatToVietnamCurrency(totalAllCart));
        
        request.getRequestDispatcher("ShowCart.jsp").forward(request, response);

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
