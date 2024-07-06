/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author TNO
 */
public class BillDetailsResponse {
    private int idBillDetais;
    private int bookID;
    private String bookName;
    private String bookPrice;
    private int amount;
    private int idBill;

    public BillDetailsResponse() {
    }

    public BillDetailsResponse(int idBillDetais, int bookID, String bookName, String bookPrice, int amount, int idBill) {
        this.idBillDetais = idBillDetais;
        this.bookID = bookID;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.amount = amount;
        this.idBill = idBill;
    }

    public int getIdBillDetais() {
        return idBillDetais;
    }

    public void setIdBillDetais(int idBillDetais) {
        this.idBillDetais = idBillDetais;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(String bookPrice) {
        this.bookPrice = bookPrice;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getIdBill() {
        return idBill;
    }

    public void setIdBill(int idBill) {
        this.idBill = idBill;
    }

    @Override
    public String toString() {
        return "BillDetailsResponse{" + "idBillDetais=" + idBillDetais + ", bookID=" + bookID + ", bookName=" + bookName + ", bookPrice=" + bookPrice + ", amount=" + amount + ", idBill=" + idBill + '}';
    }

    
    
}
