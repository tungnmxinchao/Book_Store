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
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author TNO
 */
@WebServlet(name = "PageCustomer", urlPatterns = {"/pageCustomer"})
public class PageCustomer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        Users user = (Users) session.getAttribute("user");
        
        if(user == null || user.getRole() != 2){
            response.sendRedirect("login");
            return;
        }
        
        List<Users> listUser = getListUser(request);

        request.setAttribute("listUser", listUser);
        
        request.getRequestDispatcher("CustomerManager.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private List<Users> getListUser(HttpServletRequest request) {
        UserDAO userDAO = new UserDAO();

        List<Users> listUser = null;

        String action = request.getParameter("action") == null
                ? "defaultFindAll"
                : request.getParameter("action");
        switch (action) {
            case "search":
                String name = request.getParameter("nameUser");
                listUser = userDAO.findUserByName(name);
                break;
            default:
                listUser = userDAO.findAllUsers();

        }

        return listUser;
    }

}
