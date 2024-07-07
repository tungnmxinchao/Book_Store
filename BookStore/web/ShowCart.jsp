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
            <h2>Your Shopping Cart</h2>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Total</th>
                        <th>Remove</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="listCart" items="${listCart}">
                        <tr>
                            <td>${listCart.id}</td>
                            <td>${listCart.name}</td>
                            <td>
                                <input type="text" name="quantity" data-id="${listCart.quantity}" value="${listCart.quantity}" size="2"/>
                            </td>
                            <td>${listCart.price}</td>
                            <td>${listCart.total}</td>
                            <td><a href="removeCart?action=removeItem&idBook=${listCart.id}" class="btn btn-danger"><i class="fas fa-trash-alt"></i> Remove</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
                <tfoot>
                    <tr>
                        <td colspan="4"></td>
                        <td>
                            Total: ${totalAllCart}
                        </td>
                        <td></td>
                    </tr>
                </tfoot>

            </table>
            <div class="cart-actions">
                <form action="updateCart" method="POST">
                    <input style="display: none"type="text" name="arrtayQuantity" value="" />
                    <button type="submit" class="btn btn-primary"><i class="fas fa-sync-alt"></i> Update</button>
                </form>   
                <a href="removeCart?action=removeAll" class="btn btn-danger"><i class="fas fa-trash"></i> Remove All</a>
            </div>
            <div class="cart-actions">
                <a href="checkOut" class="btn btn-primary"><i></i> Checkout</a>
                <h4 style="color: red">${msg}</h4>
            </div>
        </div>

        <!-- Script Bootstrap and Font Awesome -->
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/js/all.min.js"></script>

        <script>
            function updateArrtayQuantity() {
                const quantityElements = document.querySelectorAll("input[name='quantity']");
                let quantities = [];

                quantityElements.forEach(function (el) {
                    quantities.push(el.value);
                });

                document.querySelector("input[name='arrtayQuantity']").value = quantities.join(",");
            }

            document.querySelector("form").addEventListener("submit", updateArrtayQuantity);
        </script>
    </body>
</html>
