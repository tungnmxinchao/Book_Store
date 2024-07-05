/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import entity.Book;
import entity.BookResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import utils.GetDataUtils;

/**
 *
 * @author TNO
 */
public class BookDAO {

    private PreparedStatement ps;
    private ResultSet rs;
    private List<BookResponse> listBook;

    public BookDAO() {
        listBook = new ArrayList<>();
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

}
