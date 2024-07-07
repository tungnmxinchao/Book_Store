<%-- 
    Document   : Content
    Created on : Jul 7, 2024, 1:15:47 PM
    Author     : TNO
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Content</title>
        <link href="css/style.css" rel="stylesheet" type="text/css" />
        <style>
            .product-image {
                max-width: 100%;
                max-height: 250px;
                width: auto;
                height: auto;
            }

            .product p {
                text-align: left;
                padding-left: 10px;
                word-wrap: break-word;
                white-space: pre-wrap;
            }

            .product h2 {
                word-wrap: break-word;
                white-space: pre-wrap;
            }
        </style>

    </head>
    <body>
        <div class="products">
            <c:forEach var="listBook" items="${listBook}">
                <div class="product">
                    <img src="${listBook.image}" alt="" class="product-image">
                    <h2>${listBook.name}</h2>
                    <p>Price: ${listBook.price}</p>
                    <p>Description: ${listBook.description}</p>
                    <form action="addToCart" method="post">
                        <input type="hidden" name="idBook" value="${listBook.idBook}" />
                        <button type="submit">Add to Cart</button>
                    </form>

                </div>
            </c:forEach>
        </div>
    </body>
</html>

