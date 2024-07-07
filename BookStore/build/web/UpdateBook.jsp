<%-- 
    Document   : AddProduct
    Created on : Jul 7, 2024, 6:43:42 PM
    Author     : TNO
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Add Product</title>
        <link href="css/addProduct.css" rel="stylesheet" type="text/css" />
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
                <h2>Update Product</h2>
                <h4 style="color: red">${msg}</h4>
                <form action="updateBook" method="POST" enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="name">Name:</label>
                        <input type="text" id="name" value="${book.name}" name="bookName" required>
                    </div>
                    <div class="form-group">
                        <label for="image">Image:</label>
                        <input type="file" id="image" name="image" accept="image/*" onchange="previewImage(event)">
                        <br>
                        <img id="imagePreview" src="${book.image}" alt="Image Preview" style="max-width: 200px; max-height: 200px; margin-top: 10px;">
                    </div>
                    <div class="form-group">
                        <label for="quantity">Quantity:</label>
                        <input type="number" id="quantity" value="${book.quantity}" name="quantity" required>
                    </div>
                    <div class="form-group">
                        <label for="author">Author:</label>
                        <input type="text" id="author" value="${book.author}" name="author" required>
                    </div>
                    <div class="form-group">
                        <label for="dateOfPublication">Date of Publication:</label>
                        <input type="date" id="dateOfPublication" value="${book.date}" name="dateOfPublication" required>
                    </div>

                    <div class="form-group">
                        <label for="price">Price:</label>
                        <input type="text" id="price" value="${book.price}" name="price" step="0.01" required>
                    </div>
                    <div class="form-group">
                        <label for="publisher">Publisher:</label>
                        <input type="text" id="publisher" value="${book.publisher}" name="publisher" required>
                    </div>
                    <div class="form-group">
                        <label for="description">Description:</label>
                        <textarea id="description" name="description" rows="4" required>${book.description}</textarea>
                    </div>
                    <div class="form-group">
                        <label for="category">Category:</label>
                        <select id="category" name="category" required>
                            <c:forEach items="${listCategory}" var="listCategory">
                                <option ${book.category == listCategory.idCategory ? 'selected' : ""} value="${listCategory.idCategory}">${listCategory.name}</option> 
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="status">Status:</label>
                        <select id="status" name="status" required>
                            <option ${book.status == 1 ? 'selected' : ""} value="1">Public</option>
                            <option ${book.status == 2 ? 'selected' : ""} value="2">Private</option>
                        </select>
                    </div>
                    <input style="display: none" Ftype="text" id="name" value="${book.idBook}" name="bookID" required>
                    <button type="submit" class="button submit-btn"><i class="fas fa-plus"></i> Update Product</button>
                </form>
                <a href="pageProduct" class="button back-btn"><i class="fas fa-arrow-left"></i> Back</a>
            </div>
        </div>
    </body>
</html>
