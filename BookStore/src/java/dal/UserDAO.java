/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import entity.Users;
import java.sql.*;

/**
 *
 * @author TNO
 */
public class UserDAO extends DBContext {

    private PreparedStatement ps;
    private ResultSet rs;

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
                String address = rs.getString(5);
                String phoneNum = rs.getString(6);
                int role = rs.getInt(7);
                int status = rs.getInt(8);

                user = new Users(userID, username, password, fullName,
                        address, phoneNum, role, status);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBContext.closeResultSetAndStatement(rs, ps);
        }
        
        return user;
    }
}
