/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import entity.Users;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TNO
 */
public class UserDAO extends DBContext {

    private PreparedStatement ps;
    private ResultSet rs;
    private List<Users> listUser;

    public UserDAO() {
        listUser = new ArrayList<>();
    }

    public Users findUser(String usernameInput, String passInput) {
        String sql = "select * from Users u\n"
                + "where u.username = ? and u.[password] = ?";

        Users user = null;

        try (Connection connection = new DBContext().connection) {
            ps = connection.prepareStatement(sql);

            ps.setString(1, usernameInput);
            ps.setString(2, passInput);

            rs = ps.executeQuery();

            if (rs.next()) {
                int userID = rs.getInt(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                String fullName = rs.getString(4);
                String rollNum = rs.getString(5);
                String phoneNum = rs.getString(6);
                int role = rs.getInt(7);
                int status = rs.getInt(8);

                user = new Users(userID, username, password, fullName,
                        rollNum, phoneNum, role, status);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBContext.closeResultSetAndStatement(rs, ps);
        }

        return user;
    }

    public List<Users> findAllUsers() {
        String sql = "select * from Users";

        try (Connection connection = new DBContext().connection) {
            ps = connection.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                int userID = rs.getInt(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                String fullName = rs.getString(4);
                String rollNum = rs.getString(5);
                String phoneNum = rs.getString(6);
                int role = rs.getInt(7);
                int status = rs.getInt(8);

                Users user = new Users(userID, username, password, fullName,
                        rollNum, phoneNum, role, status);

                listUser.add(user);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBContext.closeResultSetAndStatement(rs, ps);
        }

        return listUser;
    }

    public List<Users> findUserByName(String name) {
        String sql = "select * from Users u\n"
                + "where u.full_name like ?";

        try (Connection connection = new DBContext().connection) {
            ps = connection.prepareStatement(sql);

            ps.setString(1, "%" + name + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                int userID = rs.getInt(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                String fullName = rs.getString(4);
                String rollNum = rs.getString(5);
                String phoneNum = rs.getString(6);
                int role = rs.getInt(7);
                int status = rs.getInt(8);

                Users user = new Users(userID, username, password, fullName,
                        rollNum, phoneNum, role, status);

                listUser.add(user);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBContext.closeResultSetAndStatement(rs, ps);
        }

        return listUser;
    }

    public boolean updateStatusUser(int idUser, int status) {
        String sql = "UPDATE [dbo].[Users]\n"
                + "SET [status] = ?\n"
                + "WHERE [user_id] = ?";
        try (Connection connection = new DBContext().connection) {

            ps = connection.prepareStatement(sql);

            ps.setInt(1, status);
            ps.setInt(2, idUser);

            int rowAffected = ps.executeUpdate();

            return rowAffected > 0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBContext.closeResultSetAndStatement(rs, ps);
        }

        return false;
    }

    public boolean register(String username, String password, String fullName,
            String rollNum, String phone, int role, int status) {
        String sql = "INSERT INTO Users (username, password, full_name, rollNumber, phone, role, status) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = new DBContext().connection) {

            ps = connection.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, fullName);
            ps.setString(4, rollNum);
            ps.setString(5, phone);
            ps.setInt(6, 1);
            ps.setInt(7, 1);

            int rowAffected = ps.executeUpdate();

            return rowAffected > 0;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBContext.closeResultSetAndStatement(rs, ps);
        }
        return false;
    }

}
