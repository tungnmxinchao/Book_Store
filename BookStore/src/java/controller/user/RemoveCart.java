/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.user;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author TNO
 */
@WebServlet(name = "RemoveCart", urlPatterns = {"/removeCart"})
public class RemoveCart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        HashMap<String, Integer> cartHashMap = (HashMap<String, Integer>) session.getAttribute("cartHashMap");

        if (!action.equals("removeAll")) {
            String idBook = request.getParameter("idBook");

            if (deleteFromCart(idBook, cartHashMap)) {
                response.sendRedirect("pageCart");
                return;
            }
        } else {
            cartHashMap.clear();
            
            response.sendRedirect("pageCart");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private boolean deleteFromCart(String idBook, HashMap<String, Integer> cartHashMap) {
        Iterator<Map.Entry<String, Integer>> iterator = cartHashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            String[] key = entry.getKey().split(" ");
            String bookID = key[0];

            if (bookID.equalsIgnoreCase(idBook)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

}
