<%-- 
    Document   : Menu
    Created on : Jul 7, 2024, 1:15:20 PM
    Author     : TNO
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Menu</title>
        <link href="css/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <div class="container">
            <div class="menu">
                <c:choose>
                    <c:when test="${sessionScope.user.role == 2}">
                        <h3>Admin Panel</h3>
                        <ul>
                            <li><a href="pageCustomer" class="button"><i class="fas fa-users"></i> Customer Manager</a></li>
                            <li><a href="pageProduct" class="button"><i class="fas fa-box"></i> Product Manager</a></li>
                            <li><a href="pageBill" class="button"><i class="fas fa-file-invoice-dollar"></i> Bill Manager</a></li>
                        </ul>
                    </c:when>
                    <c:otherwise>
                        <h3>Category</h3>
                        <ul>
                            <c:forEach var="listCategory" items="${listCategory}">
                                <li><a href="home?action=category&categoryID=${listCategory.idCategory}">${listCategory.name}</a></li>
                            </c:forEach>
                            <c:if test="${empty listCategory}">
                                <li>No brands available</li>
                            </c:if>
                        </ul>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </body>
</html>

