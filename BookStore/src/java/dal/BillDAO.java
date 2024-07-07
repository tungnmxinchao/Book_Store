/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import entity.BillDetailsResponse;
import entity.BillResponse;
import java.sql.Date;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.GetDataUtils;

/**
 *
 * @author TNO
 */
public class BillDAO extends DBContext {

    private PreparedStatement ps;
    private ResultSet rs;
    private List<BillResponse> listBill;
    private List<BillDetailsResponse> listBillDetails;

    public BillDAO() {
        listBill = new ArrayList<>();
        listBillDetails = new ArrayList<>();
    }

    public List<BillResponse> findAllBill() {
        String sql = "select * from Bill";

        try (Connection connection = new DBContext().connection) {
            ps = connection.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                int idBill = rs.getInt(1);
                Date date = rs.getDate(2);
                String fullNameUser = rs.getString(3);
                int idUser = rs.getInt(4);
                int total = rs.getInt(5);
                int status = rs.getInt(6);

                BillResponse bill = new BillResponse(idBill, date,
                        fullNameUser, idUser,
                        GetDataUtils.formatToVietnamCurrency(total), status);

                listBill.add(bill);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBContext.closeResultSetAndStatement(rs, ps);
        }
        return listBill;
    }

    public List<BillResponse> findBillByCustomerName(String customerNameInput) {
        String sql = "select * from Bill b\n"
                + "where b.customer_name like ?";

        try (Connection connection = new DBContext().connection) {
            ps = connection.prepareStatement(sql);
            
            ps.setString(1, "%" + customerNameInput + "%");

            rs = ps.executeQuery();

            while (rs.next()) {
                int idBill = rs.getInt(1);
                Date date = rs.getDate(2);
                String fullNameUser = rs.getString(3);
                int idUser = rs.getInt(4);
                int total = rs.getInt(5);
                int status = rs.getInt(6);

                BillResponse bill = new BillResponse(idBill, date,
                        fullNameUser, idUser,
                        GetDataUtils.formatToVietnamCurrency(total), status);

                listBill.add(bill);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBContext.closeResultSetAndStatement(rs, ps);
        }
        return listBill;
    }

    public BillResponse findBillByID(int idBillInput) {
        String sql = "select * from Bill b\n"
                + "where b.bill_id = ?";

        BillResponse bill = null;

        try (Connection connection = new DBContext().connection) {
            ps = connection.prepareStatement(sql);

            ps.setInt(1, idBillInput);

            rs = ps.executeQuery();

            while (rs.next()) {
                int idBill = rs.getInt(1);
                Date date = rs.getDate(2);
                String fullNameUser = rs.getString(3);
                int idUser = rs.getInt(4);
                int total = rs.getInt(5);
                int status = rs.getInt(6);

                bill = new BillResponse(idBill, date,
                        fullNameUser, idUser,
                        GetDataUtils.formatToVietnamCurrency(total), status);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBContext.closeResultSetAndStatement(rs, ps);
        }
        return bill;
    }

    public boolean updateStatusBill(int idBill, int status) {
        String sql = "UPDATE [dbo].[Bill]\n"
                + "   SET [status] = ?\n"
                + " WHERE [bill_id] = ?";

        try (Connection connection = new DBContext().connection) {
            ps = connection.prepareStatement(sql);

            ps.setInt(1, status);
            ps.setInt(2, idBill);

            int rowAffected = ps.executeUpdate();

            if (rowAffected > 0) {
                return true;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBContext.closeResultSetAndStatement(rs, ps);
        }
        return false;
    }

    public List<BillDetailsResponse> findBillDetailsByBillID(int idBill) {
        String sql = "select bd.id_bill_details, bd.book_id, b.[name], bd.amount, b.price, bd.bill_id  from BillDetails bd\n"
                + "join Books b\n"
                + "on bd.book_id = b.book_id\n"
                + "where bd.bill_id = ?";

        try (Connection connection = new DBContext().connection) {
            ps = connection.prepareStatement(sql);

            ps.setInt(1, idBill);

            rs = ps.executeQuery();

            while (rs.next()) {
                int idBillDetails = rs.getInt(1);
                int idBook = rs.getInt(2);
                String bookName = rs.getString(3);
                int amount = rs.getInt(4);
                int priceBook = rs.getInt(5);
                int billID = rs.getInt(6);

                BillDetailsResponse billDetails = new BillDetailsResponse(idBillDetails,
                        idBook, bookName, GetDataUtils.formatToVietnamCurrency(priceBook),
                        amount, billID);

                listBillDetails.add(billDetails);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBContext.closeResultSetAndStatement(rs, ps);
        }
        return listBillDetails;
    }

}
