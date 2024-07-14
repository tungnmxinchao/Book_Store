/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import dal.UserDAO;
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
@WebServlet(name = "UpdateUser", urlPatterns = {"/updateUser"})
public class UpdateUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userID = Integer.parseInt(request.getParameter("userID"));
        String fullName = request.getParameter("fullName");
        String rollNumber = request.getParameter("rollNumber");
        String phone = request.getParameter("phone");
        int role = Integer.parseInt(request.getParameter("role"));
        
        UserDAO userDAO = new UserDAO();
        
        if(userDAO.updateInforUser(userID, fullName, rollNumber, phone, role)){
            response.sendRedirect("detailsUser?idUser=" + userID);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
