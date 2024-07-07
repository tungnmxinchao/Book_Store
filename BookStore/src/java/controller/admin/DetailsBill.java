/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import dal.BillDAO;
import entity.BillDetailsResponse;
import entity.BillResponse;
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
@WebServlet(name = "DetailsBill", urlPatterns = {"/detailsBill"})
public class DetailsBill extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idBill = Integer.parseInt(request.getParameter("idBill"));

        BillDAO billDAO = new BillDAO();

        List<BillDetailsResponse> billDetails = billDAO.findBillDetailsByBillID(idBill);
        BillResponse bill = billDAO.findBillByID(idBill);
        
        request.setAttribute("bill", bill);
        request.setAttribute("billDetails", billDetails);
        
        request.getRequestDispatcher("BillDetails.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
