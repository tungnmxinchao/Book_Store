<%-- 
    Document   : Login
    Created on : Jul 7, 2024, 3:28:34 PM
    Author     : TNO
--%>

<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Login</title>
        <link href="css/login.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <div class="container">
            <h2>Login</h2>
            <h4 style="color: red">${msg}</h4>
            <form action="login" method="post">
                <div class="form-group">
                    <label for="username">Username</label>
                    <input type="text" id="username" name="username" required>
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" id="password" name="password" required>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn">Sign In</button>
                </div>
            </form>
            <div class="signup-link">
                <p>Don't have an account? <a href="register">Register</a></p>
            </div>
        </div>
    </body>
</html>

