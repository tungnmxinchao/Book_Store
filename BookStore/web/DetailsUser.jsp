

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Update User</title>
        <link href="css/updateUser.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

        <style>
            body {
                background-color: #e9f5fe;
            }

            .container {
                max-width: 800px;
                margin: 20px auto;
                padding: 20px;
                border: 1px solid #ccc;
                border-radius: 5px;
                background-color: #f9f9f9;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            .content {
                text-align: center;
            }

            .form-group {
                margin-bottom: 15px;
            }

            label {
                display: inline-block;
                width: 150px;
                text-align: left;
                font-weight: bold;
            }

            input[type="text"],
            input[type="password"],
            input[type="number"],
            textarea,
            select {
                width: calc(100% - 170px);
                padding: 8px;
                font-size: 14px;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
            }

            textarea {
                resize: vertical;
            }

            .button {
                display: inline-block;
                padding: 10px 20px;
                margin-right: 10px;
                margin-top: 10px;
                text-decoration: none;
                color: #fff;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                transition: background-color 0.3s ease;
            }

            .submit-btn {
                background-color: #4CAF50;
            }

            .back-btn {
                background-color: #f44336;
            }

            .button:hover {
                background-color: #45a049;
            }

            .button i {
                margin-right: 5px;
            }

        </style>
    </head>
    <body>
        <div class="container">
            <div class="content">
                <h2>Update User</h2>
                <h4 style="color: red">${msg}</h4>
                <form action="updateUser" method="POST">
                    <div class="form-group">
                        <label for="username">Username:</label>
                        <input disabled type="text" id="username" value="${user.username}" name="username" required>
                    </div>
                    <div class="form-group">
                        <label for="password">Password:</label>
                        <input disabled type="password" id="password" value="${user.password}" name="password" required>
                    </div>
                    <div class="form-group">
                        <label for="fullName">Full Name:</label>
                        <input type="text" id="fullName" value="${user.fullName}" name="fullName" required>
                    </div>
                    <div class="form-group">
                        <label for="rollNumber">Roll Number:</label>
                        <input type="text" id="rollNumber" value="${user.rollNumber}" name="rollNumber" required>
                    </div>
                    <div class="form-group">
                        <label for="phone">Phone:</label>
                        <input type="text" id="phone" value="${user.phone}" name="phone" required>
                    </div>
                    <div class="form-group">
                        <label for="role">Role:</label>
                        <select id="role" name="role" required>
                            <option ${user.role == 1 ? 'selected' : ""} value="1">User</option>
                            <option ${user.role == 2 ? 'selected' : ""} value="2">Admin</option>
                        </select>
                    </div>
                    <input style="display: none" type="text" id="userID" value="${user.idUser}" name="userID" required>
                    <button type="submit" class="button submit-btn"><i class="fas fa-plus"></i> Update User</button>
                </form>
                <a href="pageCustomer" class="button back-btn"><i class="fas fa-arrow-left"></i> Back</a>
            </div>
        </div>
    </body>
</html>
