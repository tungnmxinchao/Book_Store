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
import java.util.Map;

/**
 *
 * @author TNO
 */
@WebServlet(name = "UpdateCart", urlPatterns = {"/updateCart"})
public class UpdateCart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String arrayQuantityRequest = request.getParameter("arrtayQuantity");

        String[] arrayQuantity = arrayQuantityRequest.split(",");

        HttpSession session = request.getSession();

        HashMap<String, Integer> cartHashMap = (HashMap<String, Integer>) session.getAttribute("cartHashMap");
        int index = 0;

        for (Map.Entry<String, Integer> entry : cartHashMap.entrySet()) {
            String key = entry.getKey();
            if (index < arrayQuantity.length) {
                try {
                    int quantity = Integer.parseInt(arrayQuantity[index]);
                    cartHashMap.put(key, quantity);
                } catch (NumberFormatException e) {
                    System.out.println(e.getMessage());
                }
                index++;
            }
        }
        response.sendRedirect("pageCart");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
