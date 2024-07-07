<%-- 
    Document   : CustomerManager
    Created on : Jul 7, 2024, 8:41:44 PM
    Author     : TNO
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Customer Manager</title>
        <link href="css/manager.css" rel="stylesheet" type="text/css" />
        <link href="css/manager2.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    </head>
    <body>
        <div class="container">
            <div class="content">
                <h2>Customer Manager</h2>

                <div class="search-container">
                    <form action="pageCustomer">                    
                        <input type="text" placeholder="Search by full name..." name="nameUser" value="" />
                        <button name="action" value="search"type="submit"><i class="fa fa-search"></i> Search</button>
                    </form>
                </div>

                <table class="styled-table">
                    <thead>
                        <tr>
                            <th>User ID</th>
                            <th>Username</th>
                            <th>Full Name</th>
                            <th>Roll Number</th>
                            <th>Phone</th>
                            <th>Role</th>
                            <th>Status</th>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="listUser" items="${listUser}">
                            <tr>
                                <td>${listUser.idUser}</td>
                                <td>${listUser.username}</td>
                                <td>${listUser.fullName}</td>
                                <td>${listUser.rollNumber}</td>
                                <td>${listUser.phone}</td>
                                <c:if test="${listUser.role == 1}">
                                    <td>User</td>
                                </c:if>
                                <c:if test="${listUser.role == 2}">
                                    <td>Admin</td>
                                </c:if>
                                <c:if test="${listUser.status == 1}">
                                    <td>Active</td>
                                </c:if>
                                <c:if test="${listUser.status == 0}">
                                    <td>Blocked</td>
                                </c:if>
                                <td>
                                    <a href="updateStatusUser?userId=${listUser.idUser}" class="button delete-btn" onclick="return confirm('Are you sure you want to delete this user?');"><i class="fas fa-trash-alt"></i> Delete</a>
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

