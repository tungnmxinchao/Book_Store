<%-- 
    Document   : Panner
    Created on : Jul 7, 2024, 1:14:54 PM
    Author     : TNO
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Panel</title>
        <link href="css/style.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    </head>
    <body>
        <div class="panel">
            <div class="upper-row">
                <c:choose>
                    <c:when test="${not empty sessionScope.user}">
                        <div class="user-info">
                            <!--Roll Number--> 
                            <i class="fas fa-id-card"></i> ${sessionScope.user.rollNumber}
                        </div>
                        <div class="user-info">
                            <!--Full Name-->
                            <i class="fas fa-user"></i> ${sessionScope.user.fullName}
                        </div>
                        <div class="welcome">
                            <i class="fas fa-smile"></i> Welcome: ${sessionScope.user.username}
                        </div>
                    </c:when>
                </c:choose>
            </div>

            <div class="lower-row">
                <div class="actions">
                    <c:choose>
                        <c:when test="${not empty sessionScope.user}">
                            <a href="logout" class="button"><i class="fas fa-sign-out-alt"></i> Logout</a>
                            <a href="pageCart" class="button"><i class="fas fa-shopping-cart"></i> Show Cart</a>
                        </c:when>
                        <c:otherwise>
                            <a href="login" class="button"><i class="fas fa-sign-in-alt"></i> Login</a>
                            <a href="Register.jsp" class="button"><i class="fas fa-user-plus"></i> Register</a>
                        </c:otherwise>
                    </c:choose>
                </div>
                <form action="home" method="get" class="search-form">
                    <input type="text" name="bookName" placeholder="Search for products"/>
                    <button name="action" value="search" type="submit" class="button"><i class="fas fa-search"></i> Search</button>
                </form>
            </div>
        </div>
    </body>
</html>

