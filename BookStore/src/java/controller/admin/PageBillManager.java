/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import dal.BillDAO;
import entity.BillResponse;
import entity.Users;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

@WebServlet(name = "PageBillManager", urlPatterns = {"/pageBill"})
public class PageBillManager extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        Users user = (Users) session.getAttribute("user");

        if (user == null || user.getRole() != 2) {
            response.sendRedirect("login");
            return;
        }

        List<BillResponse> listBill = getListBill(request);

        request.setAttribute("listBill", listBill);

        request.getRequestDispatcher("BillManager.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private List<BillResponse> getListBill(HttpServletRequest request) {
        BillDAO billDAO = new BillDAO();

        List<BillResponse> listBill = null;

        String action = request.getParameter("action") == null
                ? "defaultFindAll"
                : request.getParameter("action");
        switch (action) {
            case "search":
                String name = request.getParameter("nameCustomer");
                listBill = billDAO.findBillByCustomerName(name);
                break;
            default:
                listBill = billDAO.findAllBill();

        }

        return listBill;
    }

}
