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
public class Book {
    private int idBook;
    private String name;
    private String image;
    private int quantity;
    private String author;
    private Date date;
    private int price;
    private String publisher;
    private String description;
    private int category;
    private int status;

    public Book() {
    }

    public Book(int idBook, String name, String image, int quantity, String author, Date date, int price, String publisher, String description, int category, int status) {
        this.idBook = idBook;
        this.name = name;
        this.image = image;
        this.quantity = quantity;
        this.author = author;
        this.date = date;
        this.price = price;
        this.publisher = publisher;
        this.description = description;
        this.category = category;
        this.status = status;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Book{" + "idBook=" + idBook + ", name=" + name + ", image=" + image + ", quantity=" + quantity + ", author=" + author + ", date=" + date + ", price=" + price + ", publisher=" + publisher + ", description=" + description + ", category=" + category + ", status=" + status + '}';
    }
    
    
}
