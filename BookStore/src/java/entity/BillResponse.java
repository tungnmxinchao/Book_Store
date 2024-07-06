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
public class BillResponse {
    private int idBill;
    private Date dateBill;
    private String fullNameCustomer;
    private int idUser;
    private String totel;
    private int starus;

    public BillResponse() {
    }

    public BillResponse(int idBill, Date dateBill, String fullNameCustomer, int idUser, String totel, int starus) {
        this.idBill = idBill;
        this.dateBill = dateBill;
        this.fullNameCustomer = fullNameCustomer;
        this.idUser = idUser;
        this.totel = totel;
        this.starus = starus;
    }

    public int getIdBill() {
        return idBill;
    }

    public void setIdBill(int idBill) {
        this.idBill = idBill;
    }

    public Date getDateBill() {
        return dateBill;
    }

    public void setDateBill(Date dateBill) {
        this.dateBill = dateBill;
    }

    public String getFullNameCustomer() {
        return fullNameCustomer;
    }

    public void setFullNameCustomer(String fullNameCustomer) {
        this.fullNameCustomer = fullNameCustomer;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getTotel() {
        return totel;
    }

    public void setTotel(String totel) {
        this.totel = totel;
    }

    public int getStarus() {
        return starus;
    }

    public void setStarus(int starus) {
        this.starus = starus;
    }

    @Override
    public String toString() {
        return "BillResponse{" + "idBill=" + idBill + ", dateBill=" + dateBill + ", fullNameCustomer=" + fullNameCustomer + ", idUser=" + idUser + ", totel=" + totel + ", starus=" + starus + '}';
    }
    
    
    
}
