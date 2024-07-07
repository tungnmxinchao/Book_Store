<%-- 
    Document   : Register
    Created on : Jul 7, 2024, 9:35:43 PM
    Author     : TNO
--%>

<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Register</title>
        <link href="css/register.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <div class="container">
            <h2>Register</h2>
            <h4 style="color: red">${msg}</h4>
            <form action="register" method="post">
                <div class="form-group">
                    <label for="username">Username</label>
                    <input type="text" id="username" name="username" required>
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" id="password" name="password" required>
                </div>
                <div class="form-group">
                    <label for="fullName">Full name</label>
                    <input type="text" id="password" name="fullName" required>
                </div>
                <div class="form-group">
                    <label for="rollNumber">Roll number</label>
                    <input type="text" id="password" name="rollNum" required>
                </div>
                <div class="form-group">
                    <label for="phone">Phone</label>
                    <input type="text" id="password" name="phone" required>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn">Sign Up</button>
                </div>
            </form>
            <div class="back-link">
                <p>Already have an account? <a href="login">Back to Login</a></p>
            </div>
        </div>
    </body>
</html>

