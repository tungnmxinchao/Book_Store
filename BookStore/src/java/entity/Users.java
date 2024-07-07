/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author TNO
 */
public class Users {
    private int idUser;
    private String username;
    private String password;
    private String fullName;
    private String rollNumber;
    private String phone;
    private int role;
    private int status;

    public Users() {
    }

    public Users(int idUser, String username, String password, String fullName, String rollNumber, String phone, int role, int status) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.rollNumber = rollNumber;
        this.phone = phone;
        this.role = role;
        this.status = status;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Users{" + "idUser=" + idUser + ", username=" + username + ", password=" + password + ", fullName=" + fullName + ", rollNumber=" + rollNumber + ", phone=" + phone + ", role=" + role + ", status=" + status + '}';
    }

    
    
    
}
