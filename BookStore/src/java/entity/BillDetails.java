/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author TNO
 */
public class BillDetails {
    private int idBillDetails;
    private int idBook;
    private int bookPrice;
    private int amount;
    private int billId;

    public BillDetails() {
    }

    public BillDetails(int idBillDetails, int idBook, int bookPrice, int amount, int billId) {
        this.idBillDetails = idBillDetails;
        this.idBook = idBook;
        this.bookPrice = bookPrice;
        this.amount = amount;
        this.billId = billId;
    }

    public int getIdBillDetails() {
        return idBillDetails;
    }

    public void setIdBillDetails(int idBillDetails) {
        this.idBillDetails = idBillDetails;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public int getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    @Override
    public String toString() {
        return "BillDetails{" + "idBillDetails=" + idBillDetails + ", idBook=" + idBook + ", bookPrice=" + bookPrice + ", amount=" + amount + ", billId=" + billId + '}';
    }
    
    
}
