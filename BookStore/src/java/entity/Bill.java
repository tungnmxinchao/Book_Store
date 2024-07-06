/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;
import java.sql.Date;
/**
 *
 * @author TNO
 */
public class Bill {
    private int idBill;
    private Date billDate;
    private String fullNameUser;
    private int idUser;
    private int total;
    private int status;

    public Bill() {
    }

    public Bill(int idBill, Date billDate, String fullNameUser, int idUser, int total, int status) {
        this.idBill = idBill;
        this.billDate = billDate;
        this.fullNameUser = fullNameUser;
        this.idUser = idUser;
        this.total = total;
        this.status = status;
    }

    public int getIdBill() {
        return idBill;
    }

    public void setIdBill(int idBill) {
        this.idBill = idBill;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public String getFullNameUser() {
        return fullNameUser;
    }

    public void setFullNameUser(String fullNameUser) {
        this.fullNameUser = fullNameUser;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Bill{" + "idBill=" + idBill + ", billDate=" + billDate + ", fullNameUser=" + fullNameUser + ", idUser=" + idUser + ", total=" + total + ", status=" + status + '}';
    }
    
    
}
