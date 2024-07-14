/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.admin;

import dal.UserDAO;
import entity.Users;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author TNO
 */
@WebServlet(name="DetailsUser", urlPatterns={"/detailsUser"})
public class DetailsUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
      int idUser = Integer.parseInt(request.getParameter("idUser"));
      
      UserDAO userDAO = new UserDAO();
      
      Users user = userDAO.findUsersByID(idUser);
      
      request.setAttribute("user", user);
      
      request.getRequestDispatcher("DetailsUser.jsp").forward(request, response);
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
