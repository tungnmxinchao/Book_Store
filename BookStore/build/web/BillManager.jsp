<%-- 
    Document   : BillManager
    Created on : Jul 7, 2024, 3:45:39 PM
    Author     : TNO
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Bill Manager</title>
        <link href="css/manager.css" rel="stylesheet" type="text/css" />
        <link href="css/manager_1.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    </head>
    <body>
        <div class="container">
            <div class="content">
                <h2>Bill Manager</h2>
                <div class="search-container">
                    <form action="pageBill">
                        <input type="text" placeholder="Search..." name="nameCustomer">
                        <button name="action" value="search" type="submit"><i class="fa fa-search"></i> Search</button>
                    </form>
                </div>

                <table class="styled-table">
                    <thead>
                        <tr>
                            <th>Bill ID</th>
                            <th>Customer Name</th>
                            <th>Date</th>
                            <th>Total</th>
                            <th>Status</th>
                            <th>View</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="listBill" items="${listBill}">
                            <tr>
                                <td>${listBill.idBill}</td>
                                <td>${listBill.fullNameCustomer}</td>
                                <td>${listBill.dateBill}</td>
                                <td>${listBill.totel}</td>
                                <c:if test="${listBill.starus == 1}">
                                    <td>Wait</td>
                                </c:if>
                                <c:if test="${listBill.starus == 2}">
                                    <td>Process</td>
                                </c:if>
                                <c:if test="${listBill.starus == 3}">
                                    <td>Done</td>
                                </c:if>
                                <td>
                                    <a href="detailsBill?idBill=${listBill.idBill}" class="button detail-btn"><i class="fas fa-eye"></i> Detail</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <a href="home" class="button back-btn"><i class="fas fa-arrow-left"></i> Back</a>
            </div>
        </div>
    </body>
</html>
