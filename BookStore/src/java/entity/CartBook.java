/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author TNO
 */
public class CartBook {
    private String id;
    private String name;
    private int price;
    private int total;
    private int quantity;

    public CartBook() {
    }

    public CartBook(String id, String name, int price, int total, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.total = total;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartBook{" + "id=" + id + ", name=" + name + ", price=" + price + ", total=" + total + ", quantity=" + quantity + '}';
    }
    
    
}
