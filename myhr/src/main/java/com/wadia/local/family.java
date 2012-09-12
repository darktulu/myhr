/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.local;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author toshiba
 */
public class family implements Serializable {
    
    private String name;
    private String surname;
    private String username;
    private String status;
    private String CIN;
    private Date Birthday;
    private String Gender;
    private String MaritalStatus;
    private int nb_spouse;
    private int nb_children;
    
    public family(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    public Date getBirthday() {
        return Birthday;
    }

    public void setBirthday(Date Birthday) {
        this.Birthday = Birthday;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getMaritalStatus() {
        return MaritalStatus;
    }

    public void setMaritalStatus(String MaritalStatus) {
        this.MaritalStatus = MaritalStatus;
    }

    public int getNb_spouse() {
        return nb_spouse;
    }

    public void setNb_spouse(int nb_spouse) {
        this.nb_spouse = nb_spouse;
    }

    public int getNb_children() {
        return nb_children;
    }

    public void setNb_children(int nb_children) {
        this.nb_children = nb_children;
    }
    
    
}
