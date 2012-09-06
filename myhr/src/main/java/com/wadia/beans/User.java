/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.beans;

/**
 *
 * @author hatim
 */
public class User {

    private String username; 
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private boolean users;
    private boolean invoice;
    private boolean buy;
    private boolean admin;
    private boolean ome;
    private boolean wtr;

    public boolean isAdmin() {
        return admin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    

    public boolean isBuy() {
        return buy;
    }

    public void setBuy(boolean buy) {
        this.buy = buy;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isInvoice() {
        return invoice;
    }

    public void setInvoice(boolean invoice) {
        this.invoice = invoice;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isUsers() {
        return users;
    }

    public void setUsers(boolean users) {
        this.users = users;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public boolean isOme() {
        return ome;
    }

    public void setOme(boolean ome) {
        this.ome = ome;
    }

    public boolean isWtr() {
        return wtr;
    }

    public void setWtr(boolean wtr) {
        this.wtr = wtr;
    }

    @Override
    public String toString() {
    
    return "username : "+username+" password : "+password+" firstname : "+firstname+" lastname : "+lastname;
    }
    
    
}
