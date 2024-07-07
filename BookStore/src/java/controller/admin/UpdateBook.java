/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import dal.BookDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import utils.GetDataUtils;

/**
 *
 * @author TNO
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50)   // 50MB
@WebServlet(name = "UpdateBook", urlPatterns = {"/updateBook"})
public class UpdateBook extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String name = request.getParameter("bookName");
            int quanitty = Integer.parseInt(request.getParameter("quantity"));
            String author = request.getParameter("author");
            String dateOfPublic = request.getParameter("dateOfPublication");
            int price = GetDataUtils.parseVietnamCurrency(request.getParameter("price"));
            String publisher = request.getParameter("publisher");
            String description = request.getParameter("description");
            int category = Integer.parseInt(request.getParameter("category"));
            int status = Integer.parseInt(request.getParameter("status"));
            int bookID = Integer.parseInt(request.getParameter("bookID"));

            BookDAO bookDAO = new BookDAO();

            String uploadFolder = getServletContext().getRealPath("") + "../../web/img";

            File folder = new File(uploadFolder);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            Part filePart = request.getPart("image");
            String fileName = getSubmittedFileName(filePart);
            String imagePath = "img/" + fileName;

            if (fileName.isEmpty()) {

                int updateImageMode = 0;
                if (bookDAO.updateBook(bookID, name, imagePath, quanitty,
                        author, dateOfPublic, price, publisher, description,
                        category, status, updateImageMode)) {
                    response.sendRedirect("bookDetails?bookId="+ bookID);
                    return;
                }
            }

            OutputStream out = null;
            InputStream fileContent = null;

            try {
                out = new FileOutputStream(new File(uploadFolder + File.separator + fileName));
                fileContent = filePart.getInputStream();

                int read = 0;
                final byte[] bytes = new byte[1024];

                while ((read = fileContent.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }

            } catch (FileNotFoundException fne) {
                fne.printStackTrace();
            } finally {
                if (out != null) {
                    out.close();
                }
                if (fileContent != null) {
                    fileContent.close();
                }
            }
            int updateImageMode = 1;
            if (bookDAO.updateBook(bookID, name, imagePath, quanitty,
                    author, dateOfPublic, price, publisher, description,
                    category, status, updateImageMode)) {
                response.sendRedirect("bookDetails?bookId="+ bookID);
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private String getSubmittedFileName(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                return cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

}
