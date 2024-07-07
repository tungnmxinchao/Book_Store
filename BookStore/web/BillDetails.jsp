<%-- 
    Document   : BillDetails
    Created on : Jul 7, 2024, 3:58:11 PM
    Author     : TNO
--%>

<%-- 
    Document   : ShowCart
    Created on : Jul 7, 2024, 1:47:03 PM
    Author     : TNO
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Show Cart</title>
        <link href="css/cart.css" rel="stylesheet" type="text/css" />
        <!-- Link Bootstrap CSS -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <!-- Link Font Awesome CSS -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
    </head>
    <style>
        body {
            background-color: #e9f5fe;
        }
    </style>
    <body>
        <div class="cart">
            <h2>Bill Details</h2>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Quantity</th>
                        <th>Price</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="billDetails" items="${billDetails}">
                        <tr>
                            <td>${billDetails.idBillDetais}</td>
                            <td>${billDetails.bookName}</td>
                            <td>${billDetails.amount}</td>
                            <td>${billDetails.bookPrice}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <form action="updateStatusBill" method="POST">
                <div>
                    <select name="statusBill">
                        <option ${bill.starus == 1 ? 'selected' : ""} value="1">Wait</option>
                        <option ${bill.starus == 2 ? 'selected' : ""} value="2">Process</option>
                        <option ${bill.starus == 3 ? 'selected' : ""} value="3">Done</option>
                    </select>
                </div>
                <div class="cart-actions">
                    <input style="display: none"type="text" name="idBill" value="${bill.idBill}" />
                    <button type="submit" class="btn btn-primary"><i class="fas fa-sync-alt"></i> Update</button>
                </div>
            </form>
        </div>

        <!-- Script Bootstrap and Font Awesome -->
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/js/all.min.js"></script>

        <script>

        </script>
    </body>
</html>
