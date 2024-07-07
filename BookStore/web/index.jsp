<%-- 
    Document   : index
    Created on : Jul 7, 2024, 1:13:37 PM
    Author     : TNO
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Home</title>
        <link href="css/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <jsp:include page="Panner.jsp" />
        <div class="container">
            <div class="menu">
                <jsp:include page="Menu.jsp" />
            </div>
            <div class="content">
                <jsp:include page="Content.jsp" />
            </div>
        </div>
    </body>
</html>

