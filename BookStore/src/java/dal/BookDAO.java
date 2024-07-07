/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import entity.BookResponse;
import entity.CartBook;
import entity.Category;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import utils.GetDataUtils;

/**
 *
 * @author TNO
 */
public class BookDAO extends DBContext {

    private PreparedStatement ps;
    private ResultSet rs;
    private List<BookResponse> listBook;
    private List<Category> listCategory;

    public BookDAO() {
        listBook = new ArrayList<>();
        listCategory = new ArrayList<>();
    }

    public List<BookResponse> findAllBook() {
        String sql = "select * from Books b\n"
                + "where b.[status] = 1";

        try (Connection connection = new DBContext().connection) {

            ps = connection.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                int bookID = rs.getInt(1);
                String name = rs.getString(2);
                String image = rs.getString(3);
                int quantity = rs.getInt(4);
                String author = rs.getString(5);
                Date datePublic = rs.getDate(6);
                int price = rs.getInt(7);
                String publisher = rs.getString(8);
                String description = rs.getString(9);
                int category = rs.getInt(10);
                int status = rs.getInt(11);

                BookResponse book = new BookResponse(bookID, name, image,
                        quantity, author, datePublic,
                        GetDataUtils.formatToVietnamCurrency(price), publisher,
                        description, category, status);

                listBook.add(book);

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBContext.closeResultSetAndStatement(rs, ps);
        }

        return listBook;
    }

    public List<BookResponse> findAllBookByCategory(int categoryInput) {
        String sql = "select * from Books b\n"
                + "where b.[status] = 1 and b.category = ?";

        try (Connection connection = new DBContext().connection) {

            ps = connection.prepareStatement(sql);

            ps.setInt(1, categoryInput);

            rs = ps.executeQuery();

            while (rs.next()) {
                int bookID = rs.getInt(1);
                String name = rs.getString(2);
                String image = rs.getString(3);
                int quantity = rs.getInt(4);
                String author = rs.getString(5);
                Date datePublic = rs.getDate(6);
                int price = rs.getInt(7);
                String publisher = rs.getString(8);
                String description = rs.getString(9);
                int category = rs.getInt(10);
                int status = rs.getInt(11);

                BookResponse book = new BookResponse(bookID, name, image,
                        quantity, author, datePublic,
                        GetDataUtils.formatToVietnamCurrency(price), publisher,
                        description, category, status);

                listBook.add(book);

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBContext.closeResultSetAndStatement(rs, ps);
        }

        return listBook;
    }

    public BookResponse findBookByID(int idBook) {
        String sql = "select * from Books b\n"
                + "where b.[status] = 1 and b.book_id = ?";

        BookResponse book = null;

        try (Connection connection = new DBContext().connection) {

            ps = connection.prepareStatement(sql);

            ps.setInt(1, idBook);

            rs = ps.executeQuery();

            while (rs.next()) {
                int bookID = rs.getInt(1);
                String name = rs.getString(2);
                String image = rs.getString(3);
                int quantity = rs.getInt(4);
                String author = rs.getString(5);
                Date datePublic = rs.getDate(6);
                int price = rs.getInt(7);
                String publisher = rs.getString(8);
                String description = rs.getString(9);
                int category = rs.getInt(10);
                int status = rs.getInt(11);

                book = new BookResponse(bookID, name, image,
                        quantity, author, datePublic,
                        GetDataUtils.formatToVietnamCurrency(price), publisher,
                        description, category, status);

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBContext.closeResultSetAndStatement(rs, ps);
        }

        return book;
    }

    public List<BookResponse> findBookByName(String bookNameInput) {
        String sql = "select * from Books b\n"
                + "where b.[status] = 1 and b.[name] like ?";
   
        try (Connection connection = new DBContext().connection) {

            ps = connection.prepareStatement(sql);

            ps.setString(1, "%" + bookNameInput + "%");

            rs = ps.executeQuery();

            while (rs.next()) {
                int bookID = rs.getInt(1);
                String name = rs.getString(2);
                String image = rs.getString(3);
                int quantity = rs.getInt(4);
                String author = rs.getString(5);
                Date datePublic = rs.getDate(6);
                int price = rs.getInt(7);
                String publisher = rs.getString(8);
                String description = rs.getString(9);
                int category = rs.getInt(10);
                int status = rs.getInt(11);

                BookResponse book = new BookResponse(bookID, name, image,
                        quantity, author, datePublic,
                        GetDataUtils.formatToVietnamCurrency(price), publisher,
                        description, category, status);
                
                listBook.add(book);

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBContext.closeResultSetAndStatement(rs, ps);
        }

        return listBook;
    }

    public boolean insertBillAndBillDetails(int idUser, String fullNameUser, int totalAllCart, List<CartBook> listCart) {
        String sql = "INSERT INTO [dbo].[Bill] ([customer_name], [user_id], [total], [status]) VALUES (?, ?, ?, ?)";

        String insertBillDetails = "INSERT INTO [dbo].[BillDetails] ([book_id], [book_price], [amount], [bill_id]) VALUES (?, ?, ?, ?)";

        try (Connection connection = new DBContext().connection) {

            ps = connection.prepareStatement(sql, ps.RETURN_GENERATED_KEYS);
            ps.setString(1, fullNameUser);
            ps.setInt(2, idUser);
            ps.setInt(3, totalAllCart);
            ps.setInt(4, 1);

            int rowAffected = ps.executeUpdate();

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int idBill = generatedKeys.getInt(1);
                    for (int i = 0; i < listCart.size(); i++) {
                        ps = connection.prepareStatement(insertBillDetails);

                        String idBillDetails = listCart.get(i).getId();
                        int price = GetDataUtils.parseVietnamCurrency(listCart.get(i).getPrice());
                        int quantity = listCart.get(i).getQuantity();

                        ps.setString(1, idBillDetails);
                        ps.setInt(2, price);
                        ps.setInt(3, quantity);
                        ps.setInt(4, idBill);

                        int rowOrderDetailsAffected = ps.executeUpdate();

                        if (rowOrderDetailsAffected < 0) {
                            return false;
                        }
                    }
                }
            }

            if (rowAffected > 0) {
                return true;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    public boolean updateBook(int bookID, String name, String image, int quantity, String author,
            String datePublic, int price, String publisher, String description,
            int category, int status, int updateImageMode) {

        String sql = "";

        switch (updateImageMode) {
            case 1:
                sql = "UPDATE [dbo].[Books]\n"
                        + "   SET [name] = ?\n"
                        + "      ,[image] = ?\n"
                        + "      ,[quantity] = ?\n"
                        + "      ,[author] = ?\n"
                        + "      ,[date_of_public] = ?\n"
                        + "      ,[price] = ?\n"
                        + "      ,[publisher] = ?\n"
                        + "      ,[description] = ?\n"
                        + "      ,[category] = ?\n"
                        + "      ,[status] = ?\n"
                        + " WHERE [book_id] = ?";
                break;
            case 0:
                sql = "UPDATE [dbo].[Books]\n"
                        + "   SET [name] = ?\n"
                        + "      ,[quantity] = ?\n"
                        + "      ,[author] = ?\n"
                        + "      ,[date_of_public] = ?\n"
                        + "      ,[price] = ?\n"
                        + "      ,[publisher] = ?\n"
                        + "      ,[description] = ?\n"
                        + "      ,[category] = ?\n"
                        + "      ,[status] = ?\n"
                        + " WHERE [book_id] = ?";
                break;
            default:
                throw new AssertionError();
        }

        try (Connection connection = new DBContext().connection) {
            ps = connection.prepareStatement(sql);

            ps.setString(1, name);
            if (updateImageMode == 1) {

                ps.setString(2, image);
                ps.setInt(3, quantity);
                ps.setString(4, author);
                ps.setString(5, datePublic);
                ps.setInt(6, price);
                ps.setString(7, publisher);
                ps.setString(8, description);
                ps.setInt(9, category);
                ps.setInt(10, status);
                ps.setInt(11, bookID);

            } else {

                ps.setInt(2, quantity);
                ps.setString(3, author);
                ps.setString(4, datePublic);
                ps.setInt(5, price);
                ps.setString(6, publisher);
                ps.setString(7, description);
                ps.setInt(8, category);
                ps.setInt(9, status);
                ps.setInt(10, bookID);

            }

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBContext.closeResultSetAndStatement(rs, ps);
        }
        return false;
    }

    public boolean updateStatusBook(int status, int bookID) {
        String sql = "UPDATE [dbo].[Books] SET [status] = ? WHERE [book_id] = ?";
        try (Connection connection = new DBContext().connection) {
            ps = connection.prepareStatement(sql);

            ps.setInt(1, status);
            ps.setInt(2, bookID);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBContext.closeResultSetAndStatement(rs, ps);
        }
        return false;
    }

    public boolean insertBook(String name, String image, int quantity, String author,
            String datePublic, int price, String publisher, String description,
            int category, int status) {
        String sql = "INSERT INTO [dbo].[Books] "
                + "([name], [image], [quantity], [author], [date_of_public], [price], [publisher], [description], [category], [status]) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = new DBContext().connection) {

            ps = connection.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, image);
            ps.setInt(3, quantity);
            ps.setString(4, author);
            ps.setString(5, datePublic);
            ps.setInt(6, price);
            ps.setString(7, publisher);
            ps.setString(8, description);
            ps.setInt(9, category);
            ps.setInt(10, status);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBContext.closeResultSetAndStatement(rs, ps);
        }
        return false;
    }

    public List<Category> findAllCategoryBook() {
        String sql = "select * from Category";
        try (Connection connection = new DBContext().connection) {

            ps = connection.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                int categoryID = rs.getInt(1);
                String name = rs.getString(2);

                Category category = new Category(categoryID, name);

                listCategory.add(category);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBContext.closeResultSetAndStatement(rs, ps);
        }

        return listCategory;
    }

}
