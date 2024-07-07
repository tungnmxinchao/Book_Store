<%-- 
    Document   : ProductManager
    Created on : Jul 7, 2024, 4:52:31 PM
    Author     : TNO
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Product Manager</title>
        <link href="css/manager.css" rel="stylesheet" type="text/css" />
        <link href="css/manager_1.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    </head>
    <body>
        <div class="container">
            <div class="content">
                <h2>Product Manager</h2>
                <div class="button-container">
                    <a href="addProduct" class="button add-btn"><i class="fas fa-plus"></i> Add Product</a>
                </div>

                <div class="search-container">
                    <form action="pageProduct">
                        <input type="text" placeholder="Search..." name="nameBook">
                        <button name="action" value="search" type="submit"><i class="fa fa-search"></i> Search</button>
                    </form>
                </div>

                <table class="styled-table">
                    <thead>
                        <tr>
                            <th>Book ID</th>
                            <th>Name</th>
                            <th>Image</th>
                            <th>Quantity</th>
                            <th>Date of Publication</th>
                            <th>Price</th>
                            <th>Publisher</th>
                            <th>Category</th>
                            <th>Status</th>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="listBook" items="${listBook}">
                            <tr>
                                <td>${listBook.idBook}</td>
                                <td>${listBook.name}</td>
                                <td><img height="100px"src="${listBook.image}" alt="" class="product-image"/></td>
                                <td>${listBook.quantity}</td>
                                <td>${listBook.date}</td>
                                <td>${listBook.price}</td>
                                <td>${listBook.publisher}</td>
                                <c:if test="${listBook.category == 1}">
                                    <td>Văn học</td>
                                </c:if>
                                <c:if test="${listBook.category == 2}">
                                    <td>Tâm lý</td>
                                </c:if>
                                <td>${listBook.status == 1 ? "Active" : "Blocked"}</td>
                                <td>
                                    <a href="bookDetails?bookId=${listBook.idBook}" class="button update-btn"><i class="fas fa-edit"></i>Details</a>
                                </td>
                                <td>
                                    <a href="deleteBook?bookId=${listBook.idBook}" class="button delete-btn" onclick="return confirm('Are you sure you want to delete this book?');"><i class="fas fa-trash-alt"></i> Delete</a>
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
